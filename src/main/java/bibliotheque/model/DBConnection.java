
package bibliotheque.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shiro
 */
public final class DBConnection {
    
    private Connection connection;
    private static volatile DBConnection instance = null;
    
    private DBConnection() {}
    
    private DBConnection(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
    }
    
    public void newInstance(String path) {
        if (instance == null) {
            try {
                instance = new DBConnection(path);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public DBConnection getInstance(String path) {
        newInstance(path);
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
}





