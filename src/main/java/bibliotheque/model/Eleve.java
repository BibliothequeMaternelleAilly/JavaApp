
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
public class Eleve {
    
    int id;
    String nom, prenom;
    
    public Eleve(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public static ArrayList<Eleve> getAll() throws SQLException {
        ArrayList<Eleve> eleves = new ArrayList();

        try (Statement statement = DBConnection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM eleves ORDER BY nom, prenom"))
        {
            while (result.next())
                eleves.add(new Eleve(result.getInt("id"),
                        result.getString("nom"),
                        result.getString("prenom")));
        }        
        
        return eleves;
    }
    
    public static Eleve getFromFullName(String name, String surname) throws SQLException, UnfoundException {
        String query = "SELECT * FROM eleves WHERE nom=? AND prenom=? ORDER BY nom, prenom";
        Eleve pupil = null;
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setString(1, name.toUpperCase());
            statement.setString(2, surname.toLowerCase());
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    pupil = new Eleve(result.getInt("id"),
                            result.getString("nom"),
                            result.getString("prenom"));
                } else throw new UnfoundException();
            }
        }
        return pupil;
    }
    
    public static ArrayList<Eleve> getAllFromFullName(String name, String surname) throws SQLException {
        ArrayList<Eleve> list = new ArrayList();
        String query = "SELECT * FROM eleves WHERE nom LIKE ? AND prenom LIKE ? ORDER BY nom, prenom";
        try (PreparedStatement statement = DBConnection.prepareStatement(query))
        {
            statement.setString(1, name.toUpperCase() + "%");
            statement.setString(2, surname.toLowerCase() + "%");
            try (ResultSet result = statement.executeQuery())
            {
                while (result.next())
                    list.add(new Eleve(result.getInt("id"),
                            result.getString("nom"),
                            result.getString("prenom")));
            }
        }
        
        return list;
    }
    
    public static ArrayList<Eleve> getAllBorrow() throws SQLException {
        ArrayList<Eleve> list = new ArrayList();
        
        String query = "SELECT * FROM eleves WHERE id IN "
                        + "(SELECT idEmprunteur FROM livres WHERE idEmprunteur IS NOT NULL) "
                        + "ORDER BY nom, prenom";
        try (PreparedStatement statement = DBConnection.prepareStatement(query);
             ResultSet result = statement.executeQuery())
        {
            while (result.next())
                list.add(new Eleve(result.getInt("id"),
                        result.getString("nom"),
                        result.getString("prenom")));
        }
        return list;
    }
    

    public void deleteEleve() throws SQLException {
        String query = "DELETE FROM eleves WHERE id=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
    
//-----------------------------Update function disabled-----------------------------\\
//
//    public void updateEleve() throws SQLException {
//        String query = "UPDATE eleves SET nom=?, prenom=? WHERE id=?";
//        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
//            statement.setString(1, nom.toUpperCase());
//            statement.setString(2, prenom.toLowerCase());
//            statement.setInt(3, id);
//            
//            statement.execute();
//            statement.close();
//        }
//    }
    
    public void insertEleve() throws SQLException {
        String query = "INSERT INTO eleves (nom, prenom) VALUES (?, ?)";
        try (PreparedStatement statemement = DBConnection.prepareStatement(query)) {
            statemement.setString(1, nom.toUpperCase());
            statemement.setString(2, prenom.toLowerCase());
            statemement.execute();
        }
    }
    
    public ArrayList<Livre> getBorrowedBooks() throws SQLException {
        ArrayList<Livre> list = new ArrayList();
        
        String query = "SELECT * FROM livres WHERE idEmprunteur=? ORDER BY titre";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, id);
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
    
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
    
    
    @Override
    public String toString() {
        String surname = this.prenom.substring(0,1).toUpperCase() + this.prenom.substring(1);
        return nom.toUpperCase() + " " + surname;
    }
}
