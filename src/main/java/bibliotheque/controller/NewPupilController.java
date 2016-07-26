
package bibliotheque.controller;

import bibliotheque.exceptions.UnfoundException;
import bibliotheque.model.Eleve;
import bibliotheque.view.NewPupil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
public class NewPupilController {

    private final NewPupil newPupilView;
    
    public NewPupilController() {
        newPupilView = new NewPupil();
        
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
                pressNoBorderButton(e.getSource());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                releaseNoBorderButton(e.getSource());
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        ActionListener cancelButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPupilView.dispose();
            }
        };
        ActionListener validateButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewPupil();
            }
        };
        
        newPupilView.getTF_name().addFocusListener(textFieldsFocusListener);
        newPupilView.getTF_surname().addFocusListener(textFieldsFocusListener);
        newPupilView.getB_validate().addMouseListener(ButtonListener);
        newPupilView.getB_cancel().addMouseListener(ButtonListener);
        
        newPupilView.getB_cancel().addActionListener(cancelButtonListener);
        newPupilView.getB_validate().addActionListener(validateButtonListener);
    }
    
    private void toggleBorder(Object obj) {
        JTextField textField = (JTextField) obj;
        textField.setBorder(textField.getBorder()==null? BorderFactory.createLineBorder(textField.getForeground()):null);
    }
    
    private void toggleTFValue(Object obj) {
        JTextField textField = (JTextField) obj;
        textField.setText(textField.getToolTipText().equals(textField.getText()) ? "":textField.getToolTipText());
    }
    
    private void pressNoBorderButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            button.setBackground(button.getForeground());
            button.setForeground(button.getForeground().darker());
        }
    }
    
    private void releaseNoBorderButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) button.setForeground(button.getBackground());
    }
    
    private boolean pupilExists(String name, String surname) {
        try {
            Eleve.getFromFullName(name, surname);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NewPupilController.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        } catch (UnfoundException ex) {
            return false;
        }
    }
    
    private void createNewPupil() {
        String name = newPupilView.getTF_name().getText(), surname = newPupilView.getTF_surname().getText();
        if (name.isEmpty() || name.equals("Nom"))
            newPupilView.showErrorMessage("Le nom ne peut pas être vide");
        else if (surname.isEmpty() || surname.equals("Prénom"))
            newPupilView.showErrorMessage("Le prénom ne peut pas être vide");
        else if (pupilExists(name, surname))
            newPupilView.showErrorMessage("Cet élève existe déjà");
        else {
            try {
                new Eleve(-1, name, surname).insertEleve();
                if (pupilExists(name, surname)) {
                    newPupilView.showMessage("L'élève a bien été enregistré");
                    newPupilView.dispose();
                } else
                    newPupilView.showErrorMessage("L'opération a échoué! Veuillez réessayer.");
            } catch (SQLException ex) {
                newPupilView.showErrorMessage("L'opération a échoué! Veuillez réessayer.");
                Logger.getLogger(NewPupilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
