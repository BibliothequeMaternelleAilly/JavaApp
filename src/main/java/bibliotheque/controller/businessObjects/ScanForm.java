/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque.controller.businessObjects;

import bibliotheque.exceptions.UnfoundException;
import bibliotheque.model.Livre;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author shiro
 */
public class ScanForm {
    
    private final JTextField barCode;
    private final JButton validateButton;
    
    public ScanForm(JTextField textField, JButton validateButton) {
        this.barCode = textField;
        this.validateButton = validateButton;
    }
    
    public Livre getBook() throws SQLException, UnfoundException {
        Livre book = Livre.getFromBarCode(barCode.getText());
        if (book.getIdEmprunteur()!=-1) throw new UnfoundException();
        return book;
    }
    
    public void returnBook() throws SQLException, UnfoundException {
        Livre current = Livre.getFromBarCode(barCode.getText());
        if (current.getIdEmprunteur()==-1) throw new UnfoundException();
        current.setIdEmprunteur(-1);
        current.setDate_emprun(null);
        current.updateLivre();
    }
    
    public void changeTextFieldValue(char c) {
        String currentText = barCode.getText();
        
        if (c=='\b' && currentText.length()!=0)
            barCode.setText(currentText.substring(0, currentText.length()-1));
        else if (currentText.length()!=13 && Character.isDigit(c))
            barCode.setText(currentText+c);
        validateButton.setEnabled(barCode.getText().length()==13);
    }
}
