
package bibliotheque.controler;

import bibliotheque.model.DBConnection;
import bibliotheque.view.MainFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

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
            public void mouseClicked(MouseEvent e) {
                showTab(e.getSource());
            }
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
        mainView.getTB_card1().addMouseListener(toggleButtonListener);
        mainView.getTB_card2().addMouseListener(toggleButtonListener);
        mainView.getTB_card3().addMouseListener(toggleButtonListener);
        mainView.getTB_card4().addMouseListener(toggleButtonListener);

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
    
    private void unselectToggleButton(JToggleButton button) {
        if (button.isSelected()) {
            button.setSelected(false);
            button.setContentAreaFilled(false);
        }
    }
    
    private void showTab(Object obj) {
        JToggleButton toggleButton = (JToggleButton) obj;
        
        String index = toggleButton.getName();
        if (!toggleButton.isSelected()) index = "card0";
        mainView.getTabGroupsLayout().show(mainView.getTabGroups(), index);
    }
    
    private void toggleButtonsClicked(Object obj) {
        JToggleButton toggleButton = (JToggleButton) obj;
        
        if (toggleButton!=mainView.getTB_card1()) unselectToggleButton(mainView.getTB_card1());
        if (toggleButton!=mainView.getTB_card2()) unselectToggleButton(mainView.getTB_card2());
        if (toggleButton!=mainView.getTB_card3()) unselectToggleButton(mainView.getTB_card3());
        if (toggleButton!=mainView.getTB_card4()) unselectToggleButton(mainView.getTB_card4());

        UIManager.put("ToggleButton.select", toggleButton.getBackground().darker());
        SwingUtilities.updateComponentTreeUI(mainView);
    }
    
    private void toggleToggleButtonsBg(Object obj) {
        JToggleButton toggleButton = (JToggleButton) obj;
        if (!toggleButton.isSelected())
            toggleButton.setContentAreaFilled(!toggleButton.isContentAreaFilled());
    }
}









