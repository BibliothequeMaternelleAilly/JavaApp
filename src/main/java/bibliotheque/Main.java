package bibliotheque;

import bibliotheque.controller.MainController;
import bibliotheque.model.DBConnection;
import java.sql.SQLException;

/**
 *
 * @author shiro
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        
        DBConnection.newInstance("/home/shiro/BDDbibliotheque.sqlite");
        MainController cntler = new MainController();
        
    }
    
}
