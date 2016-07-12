
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
             ResultSet result = statement.executeQuery("SELECT * FROM eleves"))
        {
            while (result.next())
                eleves.add(new Eleve(result.getInt("id"),
                        result.getString("nom"),
                        result.getString("prenom")));
            
            result.close();
            statement.close();
        }
        
        return eleves;
    }
    
    public static Eleve getFromName(String name, String surname) throws SQLException {
        String query = "SELECT * FROM eleves WHERE nom=? AND prenom=?";
        Eleve pupil;
        try (PreparedStatement statement = DBConnection.prepareStatement(query); ResultSet result = statement.executeQuery()) {
            result.next();
            pupil = new Eleve(result.getInt("id"),
                    result.getString("nom"),
                    result.getString("prenom"));
        }
        return pupil;
    }
    
    public static void clearTable() throws SQLException {
        String query = "DELETE FROM eleves";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.execute();
            statement.close();
        }
    }
    
    public static ArrayList<Eleve> getAllBorrow() throws SQLException {
        ArrayList<Eleve> list = new ArrayList();
        
        String query = "SELECT * FROM eleves WHERE id IN "
                         + "(SELECT idEmprunteur FROM livres WHERE idEmprunteur!='')";
        try (PreparedStatement statement = DBConnection.prepareStatement(query);
             ResultSet result = statement.executeQuery())
        {
            while (result.next())
                list.add(new Eleve(result.getInt("id"),
                        result.getString("nom"),
                        result.getString("prenom")));
            
            result.close();
            statement.close();
        }
        return list;
    }
    

    public void deleteEleve() throws SQLException {
        String query = "DELETE FROM eleves WHERE id=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, id);
            
            statement.execute();
            statement.close();
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
            statemement.close();
        }
    }
    
    public ArrayList<Livre> getBorrowedBooks() throws SQLException {
        ArrayList<Livre> list = new ArrayList();
        
        String query = "SELECT * FROM livres WHERE idEmprunteur=?";
        try (PreparedStatement statement = DBConnection.prepareStatement(query)) {
            statement.setInt(1, id);
            
            try (ResultSet result = statement.executeQuery()) {
                while (result.next())
                    list.add(new Livre(result.getInt("id"), result.getString("codeISBN"),
                            result.getString("titre"), result.getString("auteur"),
                            result.getString("mots_cles"), result.getString("theme"),
                            result.getInt("idEmprunteur"), result.getString("date_emprun")));
                
                result.close();
            }
            statement.close();
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
    
    @Override
    public String toString() {
        String surname = this.prenom.substring(0,1).toUpperCase() + this.prenom.substring(1);
        return nom + " " + surname;
    }
}
