package bibliotheque;

import bibliotheque.controller.MainControler;
import bibliotheque.model.DBConnection;
//import bibliotheque.view.SearchResult;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author shiro
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        DBConnection.newInstance("/home/shiro/BDDbibliotheque.sqlite");
        MainControler cntler = new MainControler();
        //SearchResult test = new SearchResult(cntler.getMainView().getLi_pupilList_tab3());
    }
    
}
