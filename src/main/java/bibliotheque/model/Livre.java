
package bibliotheque.model;

import bibliotheque.exceptions.UnfoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shiro
 */
public class Livre {
    
    private int id, idEmprunteur;
    private String barCode, titre, auteur, mots_cles, theme, date_emprun;
    
    public Livre(int id, String code_barre, String titre, String auteur, String mots_cles, String theme, int idEmprunteur, String date_emprun) {
        this.id = id;
        this.barCode = code_barre;
        this.titre = titre;
        this.auteur = auteur;
        this.mots_cles = mots_cles;
        this.theme = theme;
        this.idEmprunteur = idEmprunteur;
        this.date_emprun = date_emprun;
    }

    
    public static ArrayList<Livre> getAll() throws SQLException {
        ArrayList<Livre> livres = new ArrayList();
        
        try (Statement statement = DBConnection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM livres"))
        {
            while (result.next())
                livres.add(new Livre(result.getInt("id"), result.getString("code_barre"),
                                   result.getString("titre"), result.getString("auteur"),
                                   result.getString("mots_cles"), result.getString("theme"),
                                   result.getInt("idEmprunteur")==0?-1:result.getInt("idEmprunteur"),
                                   result.getString("date_emprun")));
        }
        
        return livres;
    }
    
    public static void clearTable() throws SQLException {
        String query = "DELETE FROM livres";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.execute();
        }
    }
    
    public static ArrayList<Livre> getAllBorrow() throws SQLException {
        ArrayList<Livre> list = new ArrayList();
        
        String query = "SELECT * FROM livres WHERE idEmprunteur IS NOT NULL";
        try (PreparedStatement statement = DBConnection.prepareStatement(query);
             ResultSet result = statement.executeQuery())
        {    
            while (result.next())
                list.add(new Livre(result.getInt("id"), result.getString("code_barre"),
                        result.getString("titre"), result.getString("auteur"),
                        result.getString("mots_cles"), result.getString("theme"),
                        result.getInt("idEmprunteur"), result.getString("date_emprun")));
        }
        
        return list;
    }
    
    public static Livre getFromTitle_Author(String title, String author) throws SQLException, UnfoundException {
        String query = "SELECT * FROM livres WHERE titre=? AND auteur=?";
        Livre book = null;
        
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setString(1, title);
            statement.setString(2, author);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    book = new Livre(result.getInt("id"), result.getString("code_barre"),
                            result.getString("titre"), result.getString("auteur"),
                            result.getString("mots_cles"), result.getString("theme"),
                            result.getInt("idEmprunteur")==0 ? -1:result.getInt("idEmprunteur"),
                            result.getString("date_emprun"));
                } else throw new UnfoundException();
            }
        }
        
        return book;
    }
    
    public static Livre getFromBarCode(String barCode) throws SQLException, UnfoundException {
        String query = "SELECT * FROM livres WHERE code_barre=?";
        Livre book = null;
        
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setString(1, barCode);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    book = new Livre(result.getInt("id"), result.getString("code_barre"),
                            result.getString("titre"), result.getString("auteur"),
                            result.getString("mots_cles"), result.getString("theme"),
                            result.getInt("idEmprunteur")==0 ? -1:result.getInt("idEmprunteur"),
                            result.getString("date_emprun"));
                } else throw new UnfoundException();
            }
        }
        return book;
    }
    
    public static ArrayList<Livre> getAllFromFullFields(String title, String author, String theme, String keyWords) throws SQLException {
        ArrayList<Livre> list = new ArrayList();
        String query = "SELECT * FROM livres WHERE titre LIKE ? AND auteur LIKE ? AND theme LIKE ?";
        String[] tab = keyWords.split(";");
        int l=tab.length;
        for (int i=0; i<l; i++)
            query += " AND mots_cles LIKE ?";
        
        try (PreparedStatement statement = DBConnection.prepareStatement(query))
        {    
            statement.setString(1, "%" + title + "%");
            statement.setString(2, "%" + author + "%");
            statement.setString(3, "%" + theme + "%");
            for (int i=0; i<l; i++)
                statement.setString(i+4, "%" + tab[i] + "%");
            
            try (ResultSet result = statement.executeQuery()) {
                while (result.next())
                    list.add(new Livre(result.getInt("id"), result.getString("code_barre"),
                            result.getString("titre"), result.getString("auteur"),
                            result.getString("mots_cles"), result.getString("theme"),
                            result.getInt("idEmprunteur"), result.getString("date_emprun")));
            }
        }
        
        return list;
    }
    
    
    public void deleteLivre() throws SQLException {
        String query = "DELETE FROM livres WHERE id=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
    
    public void updateLivre() throws SQLException {
        String query = "UPDATE livres SET titre=?, auteur=?, mots_cles=?, "
                                        +"theme=?, idEmprunteur=?, date_emprun=?"
                    + " WHERE id=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setString(3, mots_cles);
            statement.setString(4, theme);
            if (idEmprunteur==-1) statement.setObject(5, null);
            else statement.setInt(5, idEmprunteur);
            statement.setString(6, date_emprun);
            statement.setInt(7, id);
            
            statement.execute();
        }
    }
    
    public void insertLivre() throws SQLException {
        String query = "INSERT INTO livres (titre, auteur, mots_cles, theme,"
                                        + " idEmprunteur, date_emprun)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setString(3, mots_cles);
            statement.setString(4, theme);
            if (idEmprunteur==-1) statement.setObject(5, null);
            else statement.setInt(5, idEmprunteur);
            statement.setString(6, date_emprun);
            
            statement.execute();
        }
    }
    
    public Eleve getBorrower() throws SQLException, UnfoundException {
        if (idEmprunteur==-1) throw new UnfoundException();
        
        Eleve borrower = null;
        
        String query = "SELECT * FROM eleves WHERE id=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, idEmprunteur);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    borrower = new Eleve(result.getInt("id"),
                            result.getString("nom"),
                            result.getString("prenom"));
                }
            }
        }
        return borrower;
    }
    
    
    public int getId() {
        return id;
    }

    public int getIdEmprunteur() {
        return idEmprunteur;
    }

    public String getCode_barre() {
        return barCode;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getMots_cles() {
        return mots_cles;
    }

    public String getTheme() {
        return theme;
    }

    public String getDate_emprun() throws UnfoundException {
        if (date_emprun==null) throw new UnfoundException();
        String[] date = date_emprun.split("-");
        return date[2] + "/" + date[1] + "/" + date[0];
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEmprunteur(int idEmprunteur) {
        this.idEmprunteur = idEmprunteur;
    }

    public void setCode_barre(String barCode) {
        this.barCode = barCode;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setMots_cles(String mots_cles) {
        this.mots_cles = mots_cles;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDate_emprun(String date_emprun) {
        this.date_emprun = date_emprun;
    }
    
    
    @Override
    public String toString() {
        return titre + " (" + auteur + ")";
    }
}
