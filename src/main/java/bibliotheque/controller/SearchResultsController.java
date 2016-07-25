
package bibliotheque.controller;

import bibliotheque.controller.businessObjects.BooksManagement;
import bibliotheque.controller.businessObjects.PupilsManagement;
import bibliotheque.exceptions.UnfoundException;
import bibliotheque.model.Eleve;
import bibliotheque.model.Livre;
import bibliotheque.view.SearchResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author shiro
 */
public class SearchResultsController {
    
    private PupilsManagement formTab3;
    private BooksManagement formTab4;
    private final SearchResult searchView;
    
    public SearchResultsController(PupilsManagement formTab3) {
        this.formTab3 = formTab3;
        searchView = new SearchResult(formTab3.getModel());
        ArrayList<Eleve> list = formTab3.getResultList();
        DefaultListModel<String> model = new DefaultListModel();
        for (Eleve pupil: list)
            model.addElement(pupil.toString());
        searchView.getLi_searchResults().setModel(model);
        
        initController();
    }
    
    public SearchResultsController(BooksManagement formTab4) {
        this.formTab4 = formTab4;
        searchView = new SearchResult(formTab4.getModel());
        ArrayList<Livre> list = formTab4.getResultList();
        DefaultListModel<String> model = new DefaultListModel();
        for (Livre book: list)
            model.addElement(book.toString());
        searchView.getLi_searchResults().setModel(model);
        
        initController();
    }
    
    private void initController() {
        ActionListener validateActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateButtonAction();
            }
        };
        ActionListener cancelActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchView.dispose();
            }
        };
        ListSelectionListener resultSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                searchView.getB_validate().setEnabled(true);
            }
        };
        MouseListener noBorderButtonListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressNoBorderButton(e.getSource());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                releaseNoBorderButton(e.getSource());
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        searchView.getLi_searchResults().addListSelectionListener(resultSelectionListener);
        searchView.getB_validate().addMouseListener(noBorderButtonListener);
        searchView.getB_cancel().addMouseListener(noBorderButtonListener);
        searchView.getB_validate().addActionListener(validateActionListener);
        searchView.getB_cancel().addActionListener(cancelActionListener);
    }
    
    
    private void pressNoBorderButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) {
            button.setBackground(button.getForeground());
            button.setForeground(button.getForeground().darker());
        }
    }
    
    private void releaseNoBorderButton(Object obj) {
        JButton button = (JButton) obj;
        if (button.isEnabled()) button.setForeground(button.getBackground());
    }
    
    private void validateButtonAction() {
        try {
            if (formTab3!=null) {
                formTab3.setCurrent(formTab3.getResultList().get(searchView.getLi_searchResults().getSelectedIndex()));
                formTab3.fillFields();
            } else {
                formTab4.setCurrent(formTab4.getResultList().get(searchView.getLi_searchResults().getSelectedIndex()));
                formTab4.fillFields();
            }
            
            searchView.dispose();
        } catch (SQLException ex) {
                Logger.getLogger(SearchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnfoundException ex) {}
    }
    
}
