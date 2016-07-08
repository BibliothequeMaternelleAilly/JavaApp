
package bibliotheque.controler.businessObjects;

import bibliotheque.model.Livre;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;

/**
 *
 * @author shiro
 */
public class ScanForm {
    
    private JFormattedTextField barCode;
    private ArrayList<Livre> booksList;
    
    public ScanForm(JFormattedTextField barCode, ArrayList<Livre> booksList) {
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
    
    public JFormattedTextField getBarCode() {
        return barCode;
    }

    public void setBarCode(JFormattedTextField barCode) {
        this.barCode = barCode;
    }

    public ArrayList<Livre> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Livre> booksList) {
        this.booksList = booksList;
    }
    
}
