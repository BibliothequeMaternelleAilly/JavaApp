
package bibliotheque.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author shiro
 */
public class BgPanel extends JPanel {
    
    private Image bg_img;

    public BgPanel() {
        super();
    }
    
    public void initBackground() {
        try {
            bg_img = ImageIO.read(getClass().getResource("/background.png"));
        } catch (IOException ex) {
            Logger.getLogger(BgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        bg_img = bg_img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg_img, 0, 0, null);
    }
    
}
