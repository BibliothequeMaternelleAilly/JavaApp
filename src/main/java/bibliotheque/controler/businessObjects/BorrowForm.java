
package bibliotheque.controler.businessObjects;

import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class BorrowForm {
    
    private final ArrayList<Eleve> pupilsList;
    private final JList pupilsJList, booksJList;
    private final JTextField nameTextField, surnameTextField;
    private Eleve current;
    
    public BorrowForm(JList pupilsJList, JList booksJList, JTextField nameTextField, JTextField surnameTextField) throws SQLException {
        
        pupilsList = Eleve.getAll();
        this.booksJList = booksJList;
        this.nameTextField = nameTextField;
        this.pupilsJList = pupilsJList;
        this.surnameTextField = surnameTextField;
        
    }
    
    public void fillPupilsJList() {
        DefaultListModel<String> model = new DefaultListModel();
        for (Eleve newPupil : pupilsList)
            model.addElement(newPupil.toString());
        pupilsJList.setModel(model);
    }
    
    public void fillFields() throws SQLException {
        DefaultListModel<String> model = new DefaultListModel();
        String value = (String) pupilsJList.getSelectedValue();
        String name = value.substring(0, value.lastIndexOf(" ")),
               surname = value.substring(value.indexOf(" ")+1);
        current = Eleve.getFromName(name, surname);
        ArrayList<Livre> borrowedBooks = current.getBorrowedBooks();
        
        nameTextField.setText(name);
        surnameTextField.setText(surname);
        for (Livre book : borrowedBooks)
            model.addElement(book.toString());
        booksJList.setModel(model);
    }
    
    public void returnBook() throws SQLException {
        Livre borrowedBook = current.getBorrowedBooks().get(booksJList.getSelectedIndex());
        borrowedBook.setIdEmprunteur(-1);
        borrowedBook.setDate_emprun("NULL");
        borrowedBook.updateLivre();
        booksJList.remove(booksJList.getSelectedIndex());
    }
    
}
