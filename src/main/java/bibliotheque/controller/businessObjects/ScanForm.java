/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Livre;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class ScanForm {
    
    private final JTextField barCode;
    
    public ScanForm(JTextField textField) {
        this.barCode = textField;
    }
    
    public Livre getBook() throws SQLException {
        return Livre.getFromBarCode(barCode.getText());
    }
    
    public void returnBook() throws SQLException {
        Livre current = Livre.getFromBarCode(barCode.getText());
        current.setIdEmprunteur(-1);
        current.setDate_emprun("");
        current.updateLivre();
        if (Livre.getFromBarCode(barCode.getText())!=null) throw new SQLException();
    }
    
    public boolean isBarCodeValid() {
        return barCode.getText().replaceAll(" ", "").length()==13;
   }
    
}
