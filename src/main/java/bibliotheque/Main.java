package bibliotheque;

import bibliotheque.controler.MainControler;
import bibliotheque.model.DBConnection;

/**
 *
 * @author shiro
 */
public class Main {

    public static void main(String[] args) {
        
        DBConnection.newInstance("/home/shiro/BDDbibliotheque.sqlite");
        MainControler cntler = new MainControler();
        
    }
    
}
