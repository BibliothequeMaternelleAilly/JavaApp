package bibliotheque;

import bibliotheque.controler.MainControler;
import bibliotheque.model.DBConnection;
import bibliotheque.view.SearchResult;
import java.sql.SQLException;

/**
 *
 * @author shiro
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        
        DBConnection.newInstance("/home/shiro/BDDbibliotheque.sqlite");
        MainControler cntler = new MainControler();
        SearchResult test = new SearchResult(cntler.getMainView().getLi_pupilList_tab3());
    }
    
}
