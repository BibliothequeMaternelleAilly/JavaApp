
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class PupilsManagement {
    
    private ArrayList<Eleve> pupilsList;
    private final JList pupilsJList, booksJList;
    private final JTextField nameTextField, surnameTextField;
    private final JLabel nameLabel, surnameLabel;
    private Eleve current;
    
    public PupilsManagement(JList pupilsJList, JList booksJList, JTextField nameTextField, JTextField surnameTextField, JLabel nameLabel, JLabel surnameLabel) throws SQLException {
        
        pupilsList = Eleve.getAll();
        this.booksJList = booksJList;
        this.nameTextField = nameTextField;
        this.pupilsJList = pupilsJList;
        this.surnameTextField = surnameTextField;
        this.nameLabel = nameLabel;
        this.surnameLabel = surnameLabel;
        fillPupilsJList();
        
    }
    
    private void fillPupilsJList() {
        DefaultListModel<String> model = new DefaultListModel();
        for (Eleve newPupil : pupilsList)
            model.addElement(newPupil.toString());
        pupilsJList.setModel(model);
    }
    
    public void fillFields() throws SQLException {
        DefaultListModel<String> model = new DefaultListModel();
        String value = (String) pupilsJList.getSelectedValue();
        if (value!=null) {
            String name = value.substring(0, value.lastIndexOf(" ")),
                   surname = value.substring(value.lastIndexOf(" ")+1);
            current = Eleve.getFromFullName(name, surname);
            ArrayList<Livre> borrowedBooks = current.getBorrowedBooks();

            nameLabel.setText(name);
            surnameLabel.setText(surname);
            for (Livre book : borrowedBooks)
                model.addElement(book.toString() + " : " + book.getDate_emprun());
            booksJList.setModel(model);
        }
    }
    
    public void resetFields() throws SQLException {
        pupilsList = Eleve.getAll();
        booksJList.setModel(new DefaultListModel());
        nameTextField.setText("NOM");
        surnameTextField.setText("Prénom");
        nameLabel.setText("NOM");
        surnameLabel.setText("Prénom");
        current = null;
        fillPupilsJList();
    }
    
    public void returnBook() throws SQLException {
        Livre borrowedBook = current.getBorrowedBooks().get(booksJList.getSelectedIndex());
        borrowedBook.setIdEmprunteur(-1);
        borrowedBook.setDate_emprun("NULL");
        borrowedBook.updateLivre();
        booksJList.remove(booksJList.getSelectedIndex());
    }
    
}
