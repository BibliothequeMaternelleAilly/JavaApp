
package bibliotheque.controller;

import bibliotheque.controller.businessObjects.BooksManagement;
import bibliotheque.controller.businessObjects.PupilsManagement;
import bibliotheque.controller.businessObjects.ScanForm;
import bibliotheque.model.DBConnection;
import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import bibliotheque.view.MainFrame;
import bibliotheque.view.customComponents.CustomToggleButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author shiro
 */
public class MainControler {

    private final MainFrame mainView;
    private final Font glyphicons;
    private final Color mainMenuButtons_bg, mainMenuButtons_fg;
    private ScanForm scanTab1, scanTab2;
    private final PupilsManagement formTab3;
    private final BooksManagement formTab4;
    
    private final ArrayList<Eleve> pupilsList = Eleve.getAll();
    private final ArrayList<Livre> booksList = Livre.getAll();;

    
    public MainControler() throws SQLException {
        
        mainView = new MainFrame();
        glyphicons = mainView.getB_help().getFont();
        mainMenuButtons_bg = mainView.getB_quit().getBackground();
        mainMenuButtons_fg = mainView.getB_quit().getForeground();
        formTab3 = new PupilsManagement(mainView.getLi_pupilList_tab3(),
                                        mainView.getLi_bookList_tab3(),
                                        mainView.getTF_name_search_tab3(),
                                        mainView.getTF_surname_search_tab3());
        formTab4 = new BooksManagement(mainView.getLi_bookList_tab4(),
                                       mainView.getTA_bookTitle_infos_tab4(),
                                       mainView.getTA_author_infos_tab4(),
                                       mainView.getTA_theme_infos_tab4(),
                                       mainView.getTA_keyWords_infos_tab4(),
                                       mainView.getTA_pupilName_infos_tab4());
        
       initController();
    }
    
    private void initController() {
        
        formTab3.fillPupilsJList();
        formTab4.fillBooksJList();
        
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
        mainView.getCTB_card1().addMouseListener(toggleButtonListener);
        mainView.getCTB_card2().addMouseListener(toggleButtonListener);
        mainView.getCTB_card3().addMouseListener(toggleButtonListener);
        mainView.getCTB_card4().addMouseListener(toggleButtonListener);

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
            button.setFont(glyphicons.deriveFont((float) Math.round(glyphicons.getSize()*0.80)));
        else button.setFont(glyphicons);
    }
    
    private void unselectToggleButton(CustomToggleButton button) {
        if (button.isSelected()) {
            button.setSelected(false);
            button.setOpaque(false);
        }
    }
    
    private void showTab(Object obj) {
        CustomToggleButton toggleButton = (CustomToggleButton) obj;
        
        String index = toggleButton.getTabIndex();
        if (!toggleButton.isSelected()) index = "card0";
        mainView.getTabGroupsLayout().show(mainView.getTabGroups(), index);
    }
    
    private void toggleButtonsClicked(Object obj) {
        CustomToggleButton toggleButton = (CustomToggleButton) obj;
        
        if (toggleButton!=mainView.getCTB_card1()) unselectToggleButton(mainView.getCTB_card1());
        if (toggleButton!=mainView.getCTB_card2()) unselectToggleButton(mainView.getCTB_card2());
        if (toggleButton!=mainView.getCTB_card3()) unselectToggleButton(mainView.getCTB_card3());
        if (toggleButton!=mainView.getCTB_card4()) unselectToggleButton(mainView.getCTB_card4());

        toggleButton.toggle();
    }
    
    private void toggleToggleButtonsBg(Object obj) {
        CustomToggleButton toggleButton = (CustomToggleButton) obj;
        if (!toggleButton.isSelected())
            toggleButton.setOpaque(!toggleButton.isOpaque());
        toggleButton.repaint();
    }

    public MainFrame getMainView() {
        return mainView;
    }

}









