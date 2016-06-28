
package bibliotheque.controler;

import bibliotheque.model.DBConnection;
import bibliotheque.view.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author shiro
 */
public class MainControler {

    MainFrame mainView;
    Font glyphNormal, glyphSmall;

    public MainControler() {
        
        mainView = new MainFrame();
        glyphNormal = mainView.getB_help().getFont();
        glyphSmall = glyphNormal.deriveFont((float) Math.round(glyphNormal.getSize()*0.80));
        
        initController();
    }
    
    private void initController() {
        
        ActionListener closeActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeView();
            }
        };
        MouseListener buttonListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                mainMenuButtonsClicked(e.getSource());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                mainMenuButtonsClicked(e.getSource());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                toggleMainMenuButtonsBg(e.getSource());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                toggleMainMenuButtonsBg(e.getSource());
            }

        };
        MouseListener toggleButtonListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                toggleButtonsClicked(e.getSource());
            }
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                toggleToggleButtonsBg(e.getSource());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                toggleToggleButtonsBg(e.getSource());
            }
        };
                
        
        mainView.getB_quit().addActionListener(closeActionListener);
        mainView.getB_webSite().addMouseListener(buttonListener);
        mainView.getB_settings().addMouseListener(buttonListener);
        mainView.getB_help().addMouseListener(buttonListener);
        mainView.getB_quit().addMouseListener(buttonListener);
        mainView.getTB_tab1().addMouseListener(toggleButtonListener);
        mainView.getTB_tab2().addMouseListener(toggleButtonListener);
        mainView.getTB_tab3().addMouseListener(toggleButtonListener);
        mainView.getTB_tab4().addMouseListener(toggleButtonListener);

    }

    private void closeView() {
        mainView.dispose();
        DBConnection.close();
    }
    
    private void toggleMainMenuButtonsBg(Object obj) {
        JButton button = (JButton) obj;
        button.setOpaque(!button.isOpaque());
    }
    
    private void mainMenuButtonsClicked(Object obj) {
        JButton button = (JButton) obj;
        button.setBorderPainted(!button.isBorderPainted());
        if (button.isBorderPainted())
            button.setFont(glyphSmall);
        else button.setFont(glyphNormal);
    }
    
    private void unselectTab(JToggleButton button) {
        if (button.isSelected()) {
            button.setSelected(false);
            button.setContentAreaFilled(false);
        }
    }
    
    private void toggleButtonsClicked(Object obj) {
        JToggleButton toggleButton = (JToggleButton) obj;
        
        if (toggleButton!=mainView.getTB_tab1()) unselectTab(mainView.getTB_tab1());
        if (toggleButton!=mainView.getTB_tab2()) unselectTab(mainView.getTB_tab2());
        if (toggleButton!=mainView.getTB_tab3()) unselectTab(mainView.getTB_tab3());
        if (toggleButton!=mainView.getTB_tab4()) unselectTab(mainView.getTB_tab4());

        UIManager.put("ToggleButton.select", toggleButton.getBackground().darker());
        SwingUtilities.updateComponentTreeUI(mainView);
    }
    
    private void toggleToggleButtonsBg(Object obj) {
        JToggleButton toggleButton = (JToggleButton) obj;
        if (!toggleButton.isSelected())
            toggleButton.setContentAreaFilled(!toggleButton.isContentAreaFilled());
    }
}









