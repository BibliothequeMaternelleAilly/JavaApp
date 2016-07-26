
package bibliotheque.controller.businessObjects;

import bibliotheque.controller.NewPupilController;
import bibliotheque.controller.SearchResultsController;
import bibliotheque.exceptions.UnfoundException;
import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class PupilsManagement {
    
    private ArrayList<Eleve> pupilsList, resultList;
    private final JList pupilsJList, booksJList;
    private final JTextField nameTextField, surnameTextField;
    private final JLabel nameLabel, surnameLabel;
    private final JButton returnButton, returnAllButton, deleteButton;
    private Eleve current = null;
    private SearchResultsController resultController;
    private NewPupilController pupilController;
    
    public PupilsManagement(JButton returnButton, JButton returnAllButton, JButton deleteButton, JList pupilsJList, JList booksJList, JTextField nameTextField, JTextField surnameTextField, JLabel nameLabel, JLabel surnameLabel) throws SQLException {
        
        pupilsList = Eleve.getAllBorrow();
        this.returnButton = returnButton;
        this.returnAllButton = returnAllButton;
        this.deleteButton = deleteButton;
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
        pupilsList.stream().forEach((newPupil) -> {
            model.addElement(newPupil.toString());
        });
        pupilsJList.setModel(model);
    }
    
    public void fillFields() throws SQLException, UnfoundException {
        DefaultListModel<String> model = new DefaultListModel();
        String value = (String) pupilsJList.getSelectedValue();
        if (value!=null) {
            String name = value.substring(0, value.lastIndexOf(" ")),
                   surname = value.substring(value.lastIndexOf(" ")+1);
            current = Eleve.getFromFullName(name, surname);
        }
        if (current!=null) {
            ArrayList<Livre> borrowedBooks = current.getBorrowedBooks();

            nameLabel.setText(current.getNom());
            surnameLabel.setText(current.getPrenom());
            for (Livre book : borrowedBooks)
                model.addElement(book.toString() + " : " + book.getDate_emprun());
            booksJList.setModel(model);
            enableReturnButton();
            returnAllButton.setEnabled(booksJList.getModel().getSize()!=0);
            deleteButton.setEnabled(true);
        }
    }
    
    public void resetFields() throws SQLException {
        pupilsList = Eleve.getAllBorrow();
        booksJList.setModel(new DefaultListModel());
        nameTextField.setText("Nom");
        surnameTextField.setText("Prénom");
        nameLabel.setText("Nom");
        surnameLabel.setText("Prénom");
        current = null;
        returnButton.setEnabled(false);
        returnAllButton.setEnabled(false);
        deleteButton.setEnabled(false);
        fillPupilsJList();
    }
    
    public void returnBook() throws SQLException {
        ArrayList<Livre> books = current.getBorrowedBooks();
        int[] index = booksJList.getSelectedIndices();
        for (int i : index) {
            books.get(i).setIdEmprunteur(-1);
            books.get(i).setDate_emprun(null);
            books.get(i).updateLivre();
        }
        while (booksJList.getSelectedIndex()!=-1)
           ((DefaultListModel) booksJList.getModel()).remove(booksJList.getSelectedIndex());
    }
    
    public void returnAllBooks() throws SQLException {
        ArrayList<Livre> borrowedBooks = current.getBorrowedBooks();
        for (Livre book:borrowedBooks) {
            book.setIdEmprunteur(-1);
            book.setDate_emprun(null);
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

    public void setCurrent(Eleve current) {
        this.current = current;
    }
    
    public boolean hasCurrentBorrowed() throws SQLException {
        return !current.getBorrowedBooks().isEmpty();
    }
    
    public void searchPupil() throws SQLException {
        pupilsJList.clearSelection();
        String name = nameTextField.getText(), surname = surnameTextField.getText();
        resultList = Eleve.getAllFromFullName(name.equals("Nom")? "":name, surname.equals("Prénom")? "":surname);
        resultController = new SearchResultsController(this);
    }
    
    public void enableReturnButton() {
        returnButton.setEnabled(booksJList.getModel().getSize()!=0 && booksJList.getSelectedIndex()!=-1);
    }
    
    public void createNewPupil() {
        pupilController = new NewPupilController();
    }
    
    
    public JList getModel() {
        return pupilsJList;
    }

    public ArrayList<Eleve> getResultList() {
        return resultList;
    }
    
}
