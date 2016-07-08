package bibliotheque;

import bibliotheque.controler.MainControler;
import bibliotheque.model.DBConnection;
import java.sql.SQLException;

/**
 *
 * @author shiro
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        
        DBConnection.newInstance("/home/shiro/BDDbibliotheque.sqlite");
        MainControler cntler = new MainControler();
        
    }
    
}
