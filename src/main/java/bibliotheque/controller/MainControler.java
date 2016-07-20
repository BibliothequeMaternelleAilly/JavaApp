
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
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author shiro
 */
public class MainControler {

    private final MainFrame mainView;
    private final Font glyphicons;
    private Font defaultButtonsFont;
    private Color borderButtons_fg = Color.WHITE, borderButtons_bg;
    private final ScanForm scanTab1, scanTab2;
    private final PupilsManagement formTab3;
    private final BooksManagement formTab4;
    
    private final ArrayList<Eleve> pupilsList = Eleve.getAll();
    private final ArrayList<Livre> booksList = Livre.getAll();;

    
    public MainControler() throws SQLException {
        
        mainView = new MainFrame();
        glyphicons = mainView.getB_help().getFont();
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
        scanTab1 = new ScanForm(mainView.getFTF_barCode_tab1());
        scanTab2 = new ScanForm(mainView.getFTF_barCode_tab2());
        
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
        ActionListener deletePupilActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePupil(e.getSource());
            }
        };
        ActionListener deleteBookActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook(e.getSource());
            }
        };
        ActionListener validateScanFieldActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        };
        MouseListener mainMenuButtonsListener = new MouseListener() {
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
        MouseListener borderedButtonListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                pressBorderedButton(e.getSource());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                releaseBorderedButton(e.getSource());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                toggleBorderedButton(e.getSource());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                toggleBorderedButton(e.getSource());
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
        mainView.getB_delete_managePupil_tab3().addActionListener(deletePupilActionListener);
        mainView.getB_delete_manageBook_tab4().addActionListener(deleteBookActionListener);
        
        mainView.getB_webSite().addMouseListener(mainMenuButtonsListener);
        mainView.getB_settings().addMouseListener(mainMenuButtonsListener);
        mainView.getB_help().addMouseListener(mainMenuButtonsListener);
        mainView.getB_quit().addMouseListener(mainMenuButtonsListener);
        
        mainView.getCTB_card1().addMouseListener(toggleButtonListener);
        mainView.getCTB_card2().addMouseListener(toggleButtonListener);
        mainView.getCTB_card3().addMouseListener(toggleButtonListener);
        mainView.getCTB_card4().addMouseListener(toggleButtonListener);
        
        mainView.getLi_pupilList_tab3().addListSelectionListener(pupilTab3SelectionListener);
        mainView.getLi_bookList_tab4().addListSelectionListener(booksTab4SelectionListener);
        
        mainView.getB_validate_search_tab3().addMouseListener(defaultButtonListener);
        mainView.getB_new_managePupil_tab3().addMouseListener(defaultButtonListener);
        mainView.getB_new_manageBook_tab4().addMouseListener(defaultButtonListener);
        mainView.getB_modify_manageBook_tab4().addMouseListener(defaultButtonListener);
        mainView.getB_validate_search_tab4().addMouseListener(defaultButtonListener);
        
        mainView.getB_validate_fields_tab1().addMouseListener(borderedButtonListener);
        mainView.getB_return_infos_tab3().addMouseListener(borderedButtonListener);
        mainView.getB_delete_managePupil_tab3().addMouseListener(borderedButtonListener);
        mainView.getB_return_infos_tab4().addMouseListener(borderedButtonListener);
        mainView.getB_delete_manageBook_tab4().addMouseListener(borderedButtonListener);
        
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
        if (button.isEnabled()) {
            Color tmp = button.getBackground();
            button.setBackground(button.getForeground());
            button.setForeground(tmp);
            button.setOpaque(!button.isOpaque());
        }
    }
    
    private void pressDefaultButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            defaultButtonsFont = button.getFont();
            button.setFont(defaultButtonsFont.deriveFont((float) Math.round(defaultButtonsFont.getSize()*0.9)));
            button.setBorderPainted(true);
        }
    }
    private void releaseDefaulButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            button.setFont(defaultButtonsFont);
            button.setBorderPainted(false);
        }
    }
    
    private void selectPupil() {
        try {
            formTab3.fillFields();
            mainView.getB_delete_managePupil_tab3().setEnabled(true);
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

    private void toggleBorderedButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            Color tmp = button.getForeground();
            button.setForeground(borderButtons_fg);
            borderButtons_fg = tmp;
            button.setOpaque(!button.isOpaque());
        }
    }
    
    private void pressBorderedButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            borderButtons_bg = button.getBackground();
            button.setBackground(borderButtons_bg.darker());
        }
    }
    
    private void releaseBorderedButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) button.setBackground(borderButtons_bg);
    }
    
    private void deletePupil(Object obj) {
        JButton button = (JButton) obj;
        boolean delete = true;
        try {
            if (JOptionPane.showConfirmDialog(mainView, "Voulez-vous vraiment supprimer cet éleve: " + formTab3.getCurrent().toString(), "Confirmation de suppresion", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE)==0)
            {
                if (formTab3.hasCurrentBorrowed()) {
                    if (JOptionPane.showConfirmDialog(mainView, "Attention! L'élève semble ne pas avoir rendu de livres.\nVoulez-vous continuer?", "Confirmation de suppresion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) formTab3.returnAllBooks();
                    else delete = false;
                }
                
                if (delete) {
                    formTab3.deletePupil();
                    formTab3.resetFields();
                    releaseBorderedButton(button);
                    toggleBorderedButton(button);
                    mainView.getB_delete_managePupil_tab3().setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void deleteBook (Object obj) {
        JButton button = (JButton) obj;
        boolean delete = true;
        try {
            if (JOptionPane.showConfirmDialog(mainView, "Voulez-vous vraiment supprimer ce livre : " + formTab4.getCurrent().toString(), "Confirmation de suppresion", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE)==0)
            {
                if (formTab4.isCurrentBorrowed()) {
                    if (JOptionPane.showConfirmDialog(mainView, "Attention! Ce livre semble avoir été emprunté.\nVoulez-vous continuer?", "Confirmation de suppresion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) formTab4.returnBook();
                    else delete = false;
                }
                    
                if (delete) {
                    formTab4.deleteBook();
                    formTab4.resetFields();
                    releaseBorderedButton(button);
                    toggleBorderedButton(button);
                    mainView.getB_delete_manageBook_tab4().setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void borrowScanAction() {
        mainView.getControls_tab1Layout().show(mainView.getControls_tab1(), "card2");
        try {
            mainView.getL_bookTitle_fields_tab1().setText(scanTab1.getBook().toString());
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void returnScanAction() {
        try {
            scanTab2.returnBook();
        } catch (SQLException ex) {
            Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            

    private MainFrame getMainView() {
        return mainView;
    }

}









