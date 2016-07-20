/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque.controller.businessObjects;

import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import javax.swing.JFormattedTextField;

/**
 *
 * @author shiro
 */
public class ScanForm {
    
    private final JFormattedTextField barCode;
    
    public ScanForm(JFormattedTextField textField) {
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
    
}
