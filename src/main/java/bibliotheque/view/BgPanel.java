
package bibliotheque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
    private int width, height;

    public BgPanel() {
        super();
        try {
            bg_img = ImageIO.read(getClass().getResource("/background.png"));
        } catch (IOException ex) {
            Logger.getLogger(BgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        width = (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.75);
        height = (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.75);
        setPreferredSize(new Dimension(width, height));
        bg_img = bg_img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        width = (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.75);
        height = (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.75);
        setPreferredSize(new Dimension(width, height));
        bg_img = bg_img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(bg_img, 0, 0, null);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    
}
