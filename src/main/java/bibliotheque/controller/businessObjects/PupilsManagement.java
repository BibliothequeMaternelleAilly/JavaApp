
package bibliotheque.controller.businessObjects;

import bibliotheque.exceptions.UnfoundException;
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
    private Eleve current = null;
    
    public PupilsManagement(JList pupilsJList, JList booksJList, JTextField nameTextField, JTextField surnameTextField, JLabel nameLabel, JLabel surnameLabel) throws SQLException {
        
        pupilsList = Eleve.getAllBorrow();
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
    
    public void fillFields() throws SQLException, UnfoundException {
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
        pupilsList = Eleve.getAllBorrow();
        booksJList.setModel(new DefaultListModel());
        nameTextField.setText("NOM");
        surnameTextField.setText("Prénom");
        nameLabel.setText("NOM");
        surnameLabel.setText("Prénom");
        current = null;
        fillPupilsJList();
    }
    
    public void returnBook() throws SQLException {
        ArrayList<Livre> books = current.getBorrowedBooks();
        int[] index = booksJList.getSelectedIndices();
        if (index.length!=0) {
            for (int i : index) {
                books.get(i).setIdEmprunteur(-1);
                books.get(i).setDate_emprun("");
                books.get(i).updateLivre();
            }
        }
        while (booksJList.getSelectedIndex()!=-1)
           ((DefaultListModel) booksJList.getModel()).remove(booksJList.getSelectedIndex());
    }
    
    public void returnAllBooks() throws SQLException {
        ArrayList<Livre> borrowedBooks = current.getBorrowedBooks();
        for (Livre book:borrowedBooks) {
            book.setIdEmprunteur(-1);
            book.setDate_emprun("");
            book.updateLivre();
        }
        booksJList.setModel(new DefaultListModel());
    }
    
    public void deletePupil() throws SQLException {
        current.deleteEleve();
        current = null;
    }

    
    public Eleve getCurrent() {
        return current;
    }
    
    public boolean hasCurrentBorrowed() throws SQLException {
        return !current.getBorrowedBooks().isEmpty();
    }
    
}
