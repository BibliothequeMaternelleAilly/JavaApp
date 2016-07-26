
package bibliotheque.view;

import bibliotheque.view.customComponents.BgPanel;
import bibliotheque.view.customComponents.CustomListCellRenderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author shiro
 */
public class SearchResult extends javax.swing.JFrame {

    private JList model;
    public SearchResult(JList model) {
        
        this.model = model;
        try {
            littleBird = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("LittleBird.ttf"));
            glyphicons = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("glyphicons.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(BgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setUndecorated(true);
        initComponents();
        setVisible(true);
        mainPanel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        SP_searchResults = new javax.swing.JScrollPane();
        Li_searchResults = new javax.swing.JList<>();
        L_title = new javax.swing.JLabel();
        buttons = new javax.swing.JPanel();
        B_validate = new javax.swing.JButton();
        B_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new Color(0,0,0,0.3f));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.2)));

        mainPanel.setBackground(model.getForeground());
        mainPanel.setPreferredSize(new Dimension((int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.4), (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.4)));
        mainPanel.setLayout(new java.awt.BorderLayout());

        SP_searchResults.setBorder(javax.swing.BorderFactory.createLineBorder(model.getBackground()));
        SP_searchResults.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        SP_searchResults.setOpaque(false);

        Li_searchResults.setBackground(model.getBackground());
        Li_searchResults.setBorder(model.getBorder());
        Li_searchResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Li_searchResults.setCellRenderer(model.getCellRenderer());
        SP_searchResults.setViewportView(Li_searchResults);

        mainPanel.add(SP_searchResults, java.awt.BorderLayout.CENTER);

        L_title.setFont(littleBird.deriveFont((float) Math.round(mainPanel.getPreferredSize().height*0.13)));
        L_title.setForeground(((CustomListCellRenderer) model.getCellRenderer()).getForeground());
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Résultat de la recherche");
        mainPanel.add(L_title, java.awt.BorderLayout.NORTH);

        buttons.setOpaque(false);

        B_validate.setFont(glyphicons.deriveFont((float) Math.round(mainPanel.getPreferredSize().height*0.15)));
        B_validate.setForeground(new java.awt.Color(123, 178, 40));
        B_validate.setText("\uE084");
        B_validate.setToolTipText("Valider");
        B_validate.setBorderPainted(false);
        B_validate.setContentAreaFilled(false);
        B_validate.setEnabled(false);
        B_validate.setFocusPainted(false);
        buttons.add(B_validate);

        B_cancel.setFont(glyphicons.deriveFont((float) Math.round(mainPanel.getPreferredSize().height*0.15)));
        B_cancel.setForeground(new java.awt.Color(227, 47, 46));
        B_cancel.setText("\uE083");
        B_cancel.setToolTipText("Annuler");
        B_cancel.setBorderPainted(false);
        B_cancel.setContentAreaFilled(false);
        B_cancel.setFocusPainted(false);
        buttons.add(B_cancel);

        mainPanel.add(buttons, java.awt.BorderLayout.PAGE_END);

        mainPanel.setVisible(false);

        getContentPane().add(mainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getB_validate() {
        return B_validate;
    }

    public JList<String> getLi_searchResults() {
        return Li_searchResults;
    }

    public JButton getB_cancel() {
        return B_cancel;
    }

    
    private Font littleBird, glyphicons;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_cancel;
    private javax.swing.JButton B_validate;
    private javax.swing.JLabel L_title;
    private javax.swing.JList<String> Li_searchResults;
    private javax.swing.JScrollPane SP_searchResults;
    private javax.swing.JPanel buttons;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
