
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
    protected Livre book;
    
    public BorrowForm(JList pupilsJList, JTextField nameTextField, JTextField surnameTextField) throws SQLException {
        
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
        String name = nameTextField.getText(), surname = surnameTextField.getText();
        if (name!=null && surname!=null && !name.equals("NOM") && !surname.equals("Prénom")) {
            try {
                pupilsList = Eleve.getAllFromFullName(nameTextField.getText(), surnameTextField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (name!=null && !name.equals("NOM")) {
            try {
                pupilsList = Eleve.getAllFromName(nameTextField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (surname!=null && !surname.equals("Prénom")) {
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
    
    public void resetFields() {
        pupilsJList.setModel(new DefaultListModel());
        nameTextField.setText("NOM");
        surnameTextField.setText("Prénom");
    }
    
    public void borrowBook() throws SQLException {
        Eleve borrower = Eleve.getFromFullName(nameTextField.getText(), surnameTextField.getText());
        getBook().setIdEmprunteur(borrower.getId());
        getBook().setDate_emprun(LocalDate.now().toString());
        getBook().updateLivre();
    }

    public Livre getBook() {
        return book;
    }

    public void setBook(Livre book) {
        this.book = book;
    }
    
}
