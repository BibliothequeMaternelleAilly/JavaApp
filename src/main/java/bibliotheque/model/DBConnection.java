
package bibliotheque.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author shiro
 */
public final class DBConnection {
    
    private final Connection connection;
    private static volatile DBConnection instance = null;
    
    private DBConnection(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
    }
    
    public static void newInstance(String path) {
        if (instance == null) {
            try {
                instance = new DBConnection(path);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static DBConnection getInstance() {
        return instance;
    }
    
    public static Statement createStatement() throws SQLException {
        return instance.getConnection().createStatement();
    }
    
    public static PreparedStatement prepareStatement(String query) throws SQLException {
        return instance.getConnection().prepareStatement(query);
    }

    
    public Connection getConnection() {
        return connection;
    }
    
}





