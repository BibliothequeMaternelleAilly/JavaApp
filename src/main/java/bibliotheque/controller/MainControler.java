
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
                                        mainView.getTF_surname_search_tab3(),
                                        mainView.getL_name_infos_tab3(),
                                        mainView.getL_surname_infos_tab3());
        formTab4 = new BooksManagement(mainView.getLi_bookList_tab4(),
                                       mainView.getTA_bookTitle_infos_tab4(),
                                       mainView.getTA_author_infos_tab4(),
                                       mainView.getTA_theme_infos_tab4(),
                                       mainView.getTA_keyWords_infos_tab4(),
                                       mainView.getTA_pupilName_infos_tab4());
        
       initController();
    }
    
    private void initController() {
        
        try {
            formTab3.resetFields();
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            formTab4.resetFields();
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
                try {
                    showTab(e.getSource());
                } catch (SQLException ex) {
                    Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        MouseListener defaultButtonListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                pressDefaultButton(e.getSource());
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                releaseDefaulButton(e.getSource());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                toggleDefaultButton(e.getSource());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                toggleDefaultButton(e.getSource());
            }
        };
        ListSelectionListener pupilTab3SelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectPupil();
            }
        },
                            booksTab4SelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectBook();
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
        mainView.getLi_pupilList_tab3().addListSelectionListener(pupilTab3SelectionListener);
        mainView.getLi_bookList_tab4().addListSelectionListener(booksTab4SelectionListener);
        mainView.getB_validate_search_tab3().addMouseListener(defaultButtonListener);
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
    
    private void showTab(Object obj) throws SQLException {
        CustomToggleButton toggleButton = (CustomToggleButton) obj;
        
        String index = toggleButton.getTabIndex();
        if (!toggleButton.isSelected()) index = "card0";
        if (index.equals("card3")) formTab3.resetFields();
        else if (index.equals("card4")) formTab4.resetFields();
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
    
    private void toggleDefaultButton(Object obj) {
        JButton button = (JButton) obj;
        Color tmp = button.getBackground();
        button.setBackground(button.getForeground());
        button.setForeground(tmp);
        button.setContentAreaFilled(!button.isContentAreaFilled());
    }
    
    private void pressDefaultButton(Object obj) {
        JButton button = (JButton) obj;
        Color bg = button.getBackground();
        button.setBackground(new Color(bg.getRed()-50, bg.getGreen()-50, bg.getBlue()-50));
    }
    private void releaseDefaulButton(Object obj) {
        JButton button = (JButton) obj;
        Color bg = button.getBackground();
        button.setBackground(new Color(bg.getRed()+50, bg.getGreen()+50, bg.getBlue()+50));
    }
    
    private void selectPupil() {
        try {
            formTab3.fillFields();
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void selectBook() {
        try {
            formTab4.fillFields();
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private MainFrame getMainView() {
        return mainView;
    }

}









