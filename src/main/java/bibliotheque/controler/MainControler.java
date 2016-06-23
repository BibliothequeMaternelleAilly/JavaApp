
package bibliotheque.controler;

import bibliotheque.view.MainFrame;

/**
 *
 * @author shiro
 */
public class MainControler {

    MainFrame mainView;

    public MainControler() {
        
        mainView = new MainFrame(false);
        mainView.setVisible(true);
        
    }
    
    
    
}
