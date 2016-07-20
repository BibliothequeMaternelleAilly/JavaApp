
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class BorrowForm {
    
    private final JList pupilsJList;
    private ArrayList<Eleve> pupilsList;
    private final JTextField nameTextField, surnameTextField;
    private final Livre book;
    
    public BorrowForm(JList pupilsJList, JTextField nameTextField, JTextField surnameTextField, Livre book) throws SQLException {
        
        this.book = book;
        this.pupilsJList = pupilsJList;
        this.nameTextField = nameTextField;
        this.surnameTextField = surnameTextField;
        pupilsList = Eleve.getAll();
        DefaultListModel<String> model = new DefaultListModel();
        for (Eleve pupil : pupilsList)
            model.addElement(pupil.toString());
        this.pupilsJList.setModel(model);
    }
    
    public void updateList() {
        DefaultListModel<String> model = new DefaultListModel();
        if (!nameTextField.getText().equals("") && !surnameTextField.getText().equals("")) {
            try {
                pupilsList = Eleve.getAllFromFullName(nameTextField.getText(), surnameTextField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!nameTextField.getText().equals("")) {
            try {
                pupilsList = Eleve.getAllFromName(nameTextField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!surnameTextField.getText().equals("")) {
            try {
                pupilsList = Eleve.getAllFromSurname(surnameTextField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (Eleve pupil : pupilsList)
            model.addElement(pupil.toString());
        pupilsJList.setModel(model);
    }
    
    public void fillFields() {
        String value = (String) pupilsJList.getSelectedValue();
        nameTextField.setText(value.substring(0, value.lastIndexOf(" ")));
        surnameTextField.setText(value.substring(value.indexOf(" ")+1));     
    }
    
    public void borrowBook() throws SQLException {
        try {
            Eleve borrower = Eleve.getFromFullName(nameTextField.getText(), surnameTextField.getText());
            book.setIdEmprunteur(borrower.getId());
            book.setDate_emprun(LocalDate.now().toString());
            book.updateLivre();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
}
