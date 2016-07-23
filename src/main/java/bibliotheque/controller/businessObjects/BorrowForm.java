
package bibliotheque.controller.businessObjects;

import bibliotheque.exceptions.UnfoundException;
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
        resetFields();
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
    
    public void resetFields() throws SQLException {
        pupilsList = Eleve.getAll();
        DefaultListModel<String> model = new DefaultListModel();
        for (Eleve pupil : pupilsList)
            model.addElement(pupil.toString());
        this.pupilsJList.setModel(model);
        nameTextField.setText("NOM");
        surnameTextField.setText("Prénom");
    }
    
    public void borrowBook() throws SQLException, UnfoundException {
        Eleve borrower = Eleve.getFromFullName(nameTextField.getText(), surnameTextField.getText());
        book.setIdEmprunteur(borrower.getId());
        book.setDate_emprun(LocalDate.now().toString());
        book.updateLivre();
        if (Livre.getFromBarCode(book.getCode_barre()).getIdEmprunteur()!=borrower.getId())
            throw new SQLException();
    }

    public Livre getBook() {
        return book;
    }

    public void setBook(Livre book) {
        this.book = book;
    }
    
}
