
package bibliotheque.controler.businessObjects;

import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class BorrowForm {
    
    private final ArrayList<Eleve> pupilsList;
    private final ArrayList<Livre> booksList;
    private final JList pupilsJList, booksJList;
    private final JTextField nameTextField, surnameTextField;
    
    public BorrowForm(ArrayList pupilsList, ArrayList booksList, JList pupilsJList, JList booksJList, JTextField nameTextField, JTextField surnameTextField) {
        
        this.booksJList = booksJList;
        this.booksList = booksList;
        this.nameTextField = nameTextField;
        this.pupilsJList = booksJList;
        this.pupilsList = booksList;
        this.surnameTextField = surnameTextField;
        
    }
    
    public void fillJList() {
        
    }
    
}
