
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Livre;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author shiro
 */
public class BooksManagement {
    
    private ArrayList<Livre> booksList;
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
        fillBooksJList();
    }
    
    private void fillBooksJList() {
        DefaultListModel<String> model = new DefaultListModel();
        for (Livre newBook : booksList)
            model.addElement(newBook.toString());
        booksJList.setModel(model);
    }
    
    public void fillFields() throws SQLException {
        DefaultListModel<String> model = new DefaultListModel();
        String value = (String) booksJList.getSelectedValue();
        if (value!=null) {
            String title = value.substring(0, value.indexOf("(")-1),
                   author = value.substring(value.indexOf("(")+1, value.length()-1);
            current = Livre.getFromTitle(title, author);

            titleTextArea.setText(title);
            authorTextArea.setText(author);
            themeTextArea.setText(current.getTheme());
            pupilTextArea.setText(current.getBorrower().toString());
            TitledBorder pupilTextAreaBorder = (TitledBorder) pupilTextArea.getBorder();
            pupilTextAreaBorder.setBorder(BorderFactory.createLineBorder(new Color(246,206,253)));
            pupilTextAreaBorder.setTitle(current.getDate_emprun());
            String[] keywords = current.getMots_cles().split(";");
            keyWordsTextArea.setText("");
            for (String word : keywords)
                keyWordsTextArea.append(word + "\n");
        }
    }
    
    public void resetFields() throws SQLException {
        booksList = Livre.getAll();
        titleTextArea.setText("Titre");
        authorTextArea.setText("Auteur");
        themeTextArea.setText("Thème");
        keyWordsTextArea.setText("Mots clés");
        pupilTextArea.setText("Emprunté par...");
        fillBooksJList();
    }
    
    public void returnBook() throws SQLException {
        current.setIdEmprunteur(-1);
        current.setDate_emprun("");
        current.updateLivre();
        pupilTextArea.setText("");
    }
    
}
