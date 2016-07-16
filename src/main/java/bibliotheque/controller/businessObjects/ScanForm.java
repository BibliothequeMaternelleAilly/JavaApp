
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Livre;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;

/**
 *
 * @author shiro
 */
public class ScanForm {
    
    private final JFormattedTextField barCode;
    private final ArrayList<Livre> booksList;
    
    public ScanForm(JFormattedTextField barCode, ArrayList booksList) {
        this.barCode = barCode;
        this.booksList = booksList;
    }

    public Livre getBook() {
        int listSize = booksList.size(), i = -1;
        String code = barCode.getText();
        
        while (i!=listSize && !code.equals(booksList.get(i).getBarCode())) i++;
        
        if (code.equals(booksList.get(i).getBarCode()))
            return booksList.get(i);
        else
            return null;
    }
    
}
