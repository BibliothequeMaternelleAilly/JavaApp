
package bibliotheque.model;

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
    
    public Livre(int id, String codeISBN, String titre, String auteur, String mots_cles, String theme, int idEmprunteur, String date_emprun) {
        this.id = id;
        this.barCode = codeISBN;
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
                livres.add(new Livre(result.getInt("id"), result.getString("codeISBN"),
                                   result.getString("titre"), result.getString("auteur"),
                                   result.getString("mots_cles"), result.getString("theme"),
                                   result.getInt("idEmprunteur"), result.getString("date_emprun")));
            
            result.close();
            statement.close();
        }
        
        return livres;
    }
    
    public static void clearTable() throws SQLException {
        String query = "DELETE FROM livres";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.execute();
            statement.close();
        }
    }
    
    public static ArrayList<Livre> getAllBorrow() throws SQLException {
        ArrayList<Livre> list = new ArrayList();
        
        String query = "SELECT * FROM livres WHERE idEmprunteur!=''";
        try (PreparedStatement statement = DBConnection.prepareStatement(query);
             ResultSet result = statement.executeQuery())
        {    
            while (result.next())
                list.add(new Livre(result.getInt("id"), result.getString("codeISBN"),
                        result.getString("titre"), result.getString("auteur"),
                        result.getString("mots_cles"), result.getString("theme"),
                        result.getInt("idEmprunteur"), result.getString("date_emprun")));
            
            result.close();
            statement.close();
        }
        
        return list;
    }
    
    
    public void deleteLivre() throws SQLException {
        String query = "DELETE FROM livres WHERE id=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, id);
            
            statement.execute();
            statement.close();
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
            if (idEmprunteur==-1) statement.setString(5, "NULL");
            else statement.setInt(5, idEmprunteur);
            statement.setString(6, date_emprun);
            statement.setInt(7, id);
            
            statement.execute();
            statement.close();
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
            statement.setInt(5, idEmprunteur);
            statement.setString(6, date_emprun);
            
            statement.execute();
            statement.close();
        }
    }
    
    
    public int getId() {
        return id;
    }

    public int getIdEmprunteur() {
        return idEmprunteur;
    }

    public String getBarCode() {
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

    public String getDate_emprun() {
        return date_emprun;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEmprunteur(int idEmprunteur) {
        this.idEmprunteur = idEmprunteur;
    }

    public void setBarCode(String barCode) {
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
