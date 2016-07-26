
package bibliotheque.controller;

import bibliotheque.exceptions.UnfoundException;
import bibliotheque.model.Livre;
import bibliotheque.view.NewBook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class NewBookController {

    private final NewBook newBookView;
    
    public NewBookController() {
        newBookView = new NewBook();
        
        initController();
    }
    
    private void initController() {
        FocusListener textFieldsFocusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                if (source.getToolTipText().equals(source.getText()))
                    toggleTFValue(source);
                toggleBorder(source);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                if (source.getText().isEmpty())
                    toggleTFValue(source);
                toggleBorder((JTextField) e.getSource());
            }
        };
        MouseListener ButtonListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressButton(e.getSource());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                releaseButton(e.getSource());
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        KeyListener codeFieldListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (((JTextField) e.getSource()).getText().length()>=13 ||
                      !Character.isDigit(e.getKeyChar()))
                    e.consume();
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        };
        ActionListener cancelButtonListener = (ActionEvent e) -> {
            newBookView.dispose();
        };
        ActionListener validateButtonListener = (ActionEvent e) -> {
            createNewBook();
        };
        
        newBookView.getTF_author().addFocusListener(textFieldsFocusListener);
        newBookView.getTF_barCode().addFocusListener(textFieldsFocusListener);
        newBookView.getTF_keywords().addFocusListener(textFieldsFocusListener);
        newBookView.getTF_theme().addFocusListener(textFieldsFocusListener);
        newBookView.getTF_title().addFocusListener(textFieldsFocusListener);
        newBookView.getB_validate().addMouseListener(ButtonListener);
        newBookView.getB_cancel().addMouseListener(ButtonListener);
        
        newBookView.getTF_barCode().addKeyListener(codeFieldListener);
        
        newBookView.getB_cancel().addActionListener(cancelButtonListener);
        newBookView.getB_validate().addActionListener(validateButtonListener);
    }
    
    private void toggleBorder(Object obj) {
        JTextField textField = (JTextField) obj;
        textField.setBorder(textField.getBorder()==null? BorderFactory.createLineBorder(textField.getForeground()):null);
    }
    
    private void toggleTFValue(Object obj) {
        JTextField textField = (JTextField) obj;
        textField.setText(textField.getToolTipText().equals(textField.getText()) ? "":textField.getToolTipText());
    }
    
    private void pressButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            button.setBackground(button.getForeground());
            button.setForeground(button.getForeground().darker());
        }
    }
    
    private void releaseButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) button.setForeground(button.getBackground());
    }
    
    private boolean bookExists(String barCode) {
        try {
            Livre.getFromBarCode(barCode);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NewPupilController.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        } catch (UnfoundException ex) {
            return false;
        }
    }
    
    private void createNewBook() {
        String title = newBookView.getTF_title().getText(),
                author = newBookView.getTF_author().getText(),
                barCode = newBookView.getTF_barCode().getText(),
                theme = newBookView.getTF_theme().getText(),
                keywords = newBookView.getTF_keywords().getText().replaceAll(" ", "");
        if (title.isEmpty() || title.equals("Titre"))
            newBookView.showErrorMessage("Le titre ne peut pas être vide");
        else if (author.isEmpty() || author.equals("Auteur"))
            newBookView.showErrorMessage("L'auteur ne peut pas être vide");
        else if (barCode.isEmpty() || barCode.equals("Code-barre/Code ISBN"))
            newBookView.showErrorMessage("Le code-barre/ISBN ne peut pas être vide");
        else if (bookExists(barCode))
            newBookView.showErrorMessage("Cet élève existe déjà");
        else {
            try {
                new Livre(-1, barCode, title, author, keywords, theme, -1, null).insertLivre();
                if (bookExists(barCode)) {
                    newBookView.showMessage("Le livre a bien été enregistré");
                    newBookView.dispose();
                } else
                    newBookView.showErrorMessage("L'opération a échoué! Veuillez réessayer.");
            } catch (SQLException ex) {
                newBookView.showErrorMessage("L'opération a échoué! Veuillez réessayer.");
                Logger.getLogger(NewPupilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
