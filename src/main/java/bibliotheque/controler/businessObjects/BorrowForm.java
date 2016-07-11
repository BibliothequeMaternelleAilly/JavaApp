
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
    private final ArrayList<Livre> booksList;
    private final JList pupilsJList, booksJList;
    private final JTextField nameTextField, surnameTextField;
    
    public BorrowForm(JList pupilsJList, JList booksJList, JTextField nameTextField, JTextField surnameTextField) throws SQLException {
        
        pupilsList = Eleve.getAll();
        booksList = Livre.selectAll();
        this.booksJList = booksJList;
        this.nameTextField = nameTextField;
        this.pupilsJList = pupilsJList;
        this.surnameTextField = surnameTextField;
        
    }
    
    public void fillJList() {
        DefaultListModel<String> model = new DefaultListModel();
        for (Eleve newPupil : pupilsList)
            model.addElement(newPupil.toString());
        pupilsJList.setModel(model);
    }
    
}
