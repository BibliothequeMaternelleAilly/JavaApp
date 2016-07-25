
package bibliotheque.controller.businessObjects;

import bibliotheque.controller.SearchResultsController;
import bibliotheque.exceptions.UnfoundException;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class BooksManagement {
    
    private ArrayList<Livre> booksList, resultList;
    private SearchResultsController resultController;
    private final JButton returnButton;
    private final JList booksJList;
    private final JTextArea keyWordsInfo;
    private final JTextField titleInfo, authorInfo, themeInfo, pupilInfo;
    private final JTextField titleTextField, authorTextField, themeTextField, keyWordsTextField;
    private Livre current = null;
    
    public BooksManagement(JButton returnButton, JList booksJList, JTextField titleTextField, JTextField authorTextField, JTextField themeTextField, JTextField keyWordsTextField, JTextField titleInfo, JTextField authorInfo, JTextField themeInfo, JTextArea keyWordsInfo, JTextField pupilInfo) throws SQLException {
        
        booksList = Livre.getAllBorrow();
        this.returnButton = returnButton;
        this.booksJList = booksJList;
        this.titleInfo = titleInfo;
        this.authorInfo = authorInfo;
        this.themeInfo = themeInfo;
        this.keyWordsInfo = keyWordsInfo;
        this.pupilInfo = pupilInfo;
        
        this.titleTextField = titleTextField;
        this.authorTextField = authorTextField;
        this.themeTextField = themeTextField;
        this.keyWordsTextField = keyWordsTextField;
        fillBooksJList();
    }
    
    private void fillBooksJList() {
        DefaultListModel<String> model = new DefaultListModel();
        for (Livre newBook : booksList)
            model.addElement(newBook.toString());
        booksJList.setModel(model);
    }
    
    public void fillFields() throws SQLException, UnfoundException {
        String value = (String) booksJList.getSelectedValue();
        if (value!=null) {
            String title = value.substring(0, value.indexOf("(")-1),
                   author = value.substring(value.indexOf("(")+1, value.length()-1);
            current = Livre.getFromTitle_Author(title, author);
        }
        
        if (current!=null) {
            titleInfo.setText(current.getTitre());
            authorInfo.setText(current.getAuteur());
            themeInfo.setText(current.getTheme());
            String[] keywords = current.getMots_cles().split(";");
            keyWordsInfo.setText("");
            for (String word : keywords)
                keyWordsInfo.append(word + "\n");
            keyWordsInfo.setCaretPosition(0);
            try {
                pupilInfo.setText(current.getBorrower().toString()+" : "+current.getDate_emprun());
                returnButton.setEnabled(true);
            } catch (UnfoundException ex) {}
        }
    }
    
    public void resetFields() throws SQLException {
        booksList = Livre.getAllBorrow();
        titleInfo.setText("Titre");
        authorInfo.setText("Auteur");
        themeInfo.setText("Thème");
        keyWordsInfo.setText("Mots clés");
        pupilInfo.setText("Emprunteur");
        returnButton.setEnabled(false);
        current = null;
        fillBooksJList();
    }
    
    public void returnBook() throws SQLException {
        current.setIdEmprunteur(-1);
        current.setDate_emprun(null);
        current.updateLivre();
        current = null;
        resetFields();
    }

    public void deleteBook() throws SQLException {
        current.deleteLivre();
        current = null;
    }
    
    
    public Livre getCurrent() {
        return current;
    }
    
    public boolean isCurrentBorrowed() throws SQLException {
        try {
            current.getBorrower();
            return true;
        } catch (UnfoundException ex) {
            return false;
        }
    }

    public void searchBook() throws SQLException {
        booksJList.clearSelection();
        String title = titleTextField.getText(), author = authorTextField.getText(), theme = themeTextField.getText(), keyWords = keyWordsTextField.getText();
        resultList = Livre.getAllFromFullFields(title.equals("Titre")? "":title, author.equals("Auteur")? "":author, theme.equals("Thème")? "":theme, keyWords.equals("Mots clés")? "":keyWords.replaceAll(" ", ""));
        resultController = new SearchResultsController(this);
    }
    
    public void validateChanges() throws SQLException {
        current.setAuteur(authorInfo.getText());
        current.setMots_cles(keyWordsInfo.getText().replaceAll("\n", ";"));
        current.setTheme(themeInfo.getText());
        current.setTitre(titleInfo.getText());
        current.updateLivre();
        booksList = Livre.getAllBorrow();
        fillBooksJList();
    }
    
    
    public void setCurrent(Livre current) {
        this.current = current;
    }
    
    public JList getModel() {
        return booksJList;
    }

    public ArrayList<Livre> getResultList() {
        return resultList;
    }
    
}
