
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author shiro
 */
public class BooksManagement {
    
    private final ArrayList<Livre> booksList;
    private final JList booksJList;
    private final JTextArea titleTextArea, authorTextArea, themeTextArea, keyWordsTextArea, pupilTextArea;
    private Livre current;
    
    public BooksManagement(JList booksJList, JTextArea titleTextArea, JTextArea authorTextArea, JTextArea themeTextArea, JTextArea keyWordsTextArea, JTextArea pupilTextArea) throws SQLException {
        
        booksList = Livre.getAll();
        this.booksJList = booksJList;
        this.titleTextArea = titleTextArea;
        this.authorTextArea = authorTextArea;
        this.themeTextArea = themeTextArea;
        this.keyWordsTextArea = keyWordsTextArea;
        this.pupilTextArea = pupilTextArea;
    }
    
    public void fillBooksJList() {
        DefaultListModel<String> model = new DefaultListModel();
        for (Livre newBook : booksList)
            model.addElement(newBook.toString());
        booksJList.setModel(model);
    }
    
    public void fillFields() throws SQLException {
        DefaultListModel<String> model = new DefaultListModel();
        String value = (String) booksJList.getSelectedValue();
        String title = value.substring(0, value.indexOf("(")-1),
               author = value.substring(value.indexOf("(")+1, value.length()-1);
        current = Livre.getFromTitle(title, author);
        
        titleTextArea.setText(title);
        authorTextArea.setText(author);
        themeTextArea.setText(current.getTheme());
        pupilTextArea.setText(current.getBorrower().toString());
        String[] keywords = current.getMots_cles().split(";");
        int i = -1;
        for (String word : keywords)
            keyWordsTextArea.insert(word, i++);
    }
    
    public void returnBook() throws SQLException {
        current.setIdEmprunteur(-1);
        current.setDate_emprun("NULL");
        current.updateLivre();
        pupilTextArea.setText("");
    }
    
}
