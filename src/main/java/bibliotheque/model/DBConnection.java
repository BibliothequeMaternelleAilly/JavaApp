
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
    
    private DBConnection(String ip, String name, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://"+ip+name, user, password);
    }
    
    public static void newInstance(String ip, String name, String user, String password) throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new DBConnection(ip, name, user, password);
    }
    
    public static void close() {
        try {
            instance.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
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





