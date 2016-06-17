
package bibliotheque.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author shiro
 */
public class bgPanel extends JPanel {
    
    private Image background;

    public bgPanel() {
        super();
//        try {
//            background = ImageIO.read(new File("src/main/background.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(bgPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            URL test = getClass().getResource("/background.png");
            ImageIO.read(test);
        } catch (IOException ex) {
            Logger.getLogger(bgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
    
}
