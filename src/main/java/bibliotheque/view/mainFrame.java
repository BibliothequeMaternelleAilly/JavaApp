
package bibliotheque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shiro
 */
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    
    public mainFrame() {
        initComponents();
        setTitle("Bibliothèque");
        
        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("LittleBird.ttf"));
            titleFont = titleFont.deriveFont((float) Math.round(workingArea.getPreferredSize().height*0.1));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(bgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tabFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("ClearLine.ttf"));
            tabFont = tabFont.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(bgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            glyphicons = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("glyphicons.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new bibliotheque.view.bgPanel();
        workingArea = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        controls = new javax.swing.JPanel();
        toggleButtons = new javax.swing.JPanel();
        TB_tab1 = new javax.swing.JToggleButton();
        TB_tab2 = new javax.swing.JToggleButton();
        TB_tab3 = new javax.swing.JToggleButton();
        TB_tab4 = new javax.swing.JToggleButton();
        F_controlsPaging = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), toggleButtons.getPreferredSize(), new java.awt.Dimension(32767, 0));
        tabGroups = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        tab2 = new javax.swing.JPanel();
        tab3 = new javax.swing.JPanel();
        tab4 = new javax.swing.JPanel();
        defaultTab = new javax.swing.JPanel();
        P_titles = new javax.swing.JPanel();
        L_title1 = new javax.swing.JLabel();
        L_title2 = new javax.swing.JLabel();
        P_mainButtons = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        F_defaultTabPaging = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 350), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new Dimension((int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.75), (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.75)+getInsets().top));
        setResizable(false);

        background.setBackground(new java.awt.Color(91, 43, 5));
        background.setMinimumSize(new java.awt.Dimension(400, 300));
        background.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, (int) Math.round(background.getHeight()*0.075)));

        workingArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 226, 165)));
        workingArea.setOpaque(false);
        workingArea.setPreferredSize(new java.awt.Dimension(872, 491));
        workingArea.setPreferredSize(new Dimension((int) Math.round(background.getWidth()*0.85), (int) Math.round(background.getHeight()*0.85)+1));
        workingArea.setLayout(new java.awt.BorderLayout());

        L_title.setFont(titleFont);
        L_title.setForeground(new java.awt.Color(254, 226, 165));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Bibliotheque de l'école maternelle");
        L_title.setMaximumSize(new java.awt.Dimension(1243, 17));
        L_title.setMinimumSize(new java.awt.Dimension(1243, 17));
        workingArea.add(L_title, java.awt.BorderLayout.PAGE_START);

        controls.setOpaque(false);
        controls.setPreferredSize(new java.awt.Dimension(50, 50));
        controls.setLayout(new java.awt.BorderLayout());

        toggleButtons.setAutoscrolls(true);
        toggleButtons.setMaximumSize(new java.awt.Dimension(30000, 30000));
        toggleButtons.setOpaque(false);
        toggleButtons.setLayout(new javax.swing.BoxLayout(toggleButtons, javax.swing.BoxLayout.PAGE_AXIS));
        toggleButtons.setPreferredSize(new Dimension((int) Math.round(background.getWidth()*0.09), toggleButtons.getPreferredSize().height));

        TB_tab1.setBackground(new java.awt.Color(237, 146, 21));
        TB_tab1.setFont(tabFont);
        TB_tab1.setForeground(new java.awt.Color(253, 250, 206));
        TB_tab1.setText("Tab1");
        TB_tab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 146, 21), 4));
        TB_tab1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab1.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab1.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab1);

        TB_tab2.setBackground(new java.awt.Color(237, 66, 21));
        TB_tab2.setFont(tabFont);
        TB_tab2.setForeground(new java.awt.Color(253, 250, 206));
        TB_tab2.setText("Tab2");
        TB_tab2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 66, 21), 4));
        TB_tab2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab2.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab2.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab2);

        TB_tab3.setBackground(new java.awt.Color(237, 21, 66));
        TB_tab3.setFont(tabFont);
        TB_tab3.setForeground(new java.awt.Color(253, 250, 206));
        TB_tab3.setText("Tab3");
        TB_tab3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 21, 66), 4));
        TB_tab3.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab3.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab3.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab3);

        TB_tab4.setBackground(new java.awt.Color(208, 61, 199));
        TB_tab4.setFont(tabFont);
        TB_tab4.setForeground(new java.awt.Color(253, 250, 206));
        TB_tab4.setText("Tab4");
        TB_tab4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 61, 199), 4));
        TB_tab4.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab4.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab4.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab4);

        controls.add(toggleButtons, java.awt.BorderLayout.LINE_START);
        controls.add(F_controlsPaging, java.awt.BorderLayout.LINE_END);

        tabGroups.setOpaque(false);
        tabGroups.setLayout(new java.awt.CardLayout());

        tab1.setBackground(new java.awt.Color(237, 146, 21));
        tabGroups.add(tab1, "card2");

        tab2.setBackground(new java.awt.Color(237, 66, 21));
        tabGroups.add(tab2, "card3");

        tab3.setBackground(new java.awt.Color(237, 21, 66));
        tabGroups.add(tab3, "card4");

        tab4.setBackground(new java.awt.Color(208, 61, 199));
        tabGroups.add(tab4, "card5");

        defaultTab.setOpaque(false);
        defaultTab.setLayout(new java.awt.BorderLayout());

        P_titles.setOpaque(false);
        P_titles.setPreferredSize(new java.awt.Dimension(100, 50));

        L_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title1.setText("Bienvenue à la bibliotheque de l'école maternelle!");
        L_title1.setMaximumSize(new java.awt.Dimension(2147483647, 17));
        L_title1.setMinimumSize(new java.awt.Dimension(569, 17));
        L_title1.setPreferredSize(new java.awt.Dimension(569, 17));
        L_title1.setRequestFocusEnabled(false);
        P_titles.add(L_title1);

        L_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title2.setText("Cliquez sur un des onglets à gauche pour commencer");
        L_title2.setMaximumSize(new java.awt.Dimension(277, 17));
        L_title2.setMinimumSize(new java.awt.Dimension(277, 17));
        P_titles.add(L_title2);

        defaultTab.add(P_titles, java.awt.BorderLayout.PAGE_START);

        P_mainButtons.setBackground(new java.awt.Color(59, 18, 0));
        P_mainButtons.setForeground(new java.awt.Color(59, 18, 0));

        jButton1.setText("jButton1");
        P_mainButtons.add(jButton1);

        jButton2.setText("jButton2");
        P_mainButtons.add(jButton2);

        jButton3.setText("jButton3");
        P_mainButtons.add(jButton3);

        jButton4.setText("jButton4");
        P_mainButtons.add(jButton4);

        defaultTab.add(P_mainButtons, java.awt.BorderLayout.CENTER);
        defaultTab.add(F_defaultTabPaging, java.awt.BorderLayout.PAGE_END);

        tabGroups.add(defaultTab, "card6");

        controls.add(tabGroups, java.awt.BorderLayout.CENTER);

        workingArea.add(controls, java.awt.BorderLayout.CENTER);

        background.add(workingArea);

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }
    
    private Font titleFont;
    private Font tabFont;
    private Font glyphicons;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler F_controlsPaging;
    private javax.swing.Box.Filler F_defaultTabPaging;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_title1;
    private javax.swing.JLabel L_title2;
    private javax.swing.JPanel P_mainButtons;
    private javax.swing.JPanel P_titles;
    private javax.swing.JToggleButton TB_tab1;
    private javax.swing.JToggleButton TB_tab2;
    private javax.swing.JToggleButton TB_tab3;
    private javax.swing.JToggleButton TB_tab4;
    private bibliotheque.view.bgPanel background;
    private javax.swing.JPanel controls;
    private javax.swing.JPanel defaultTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tabGroups;
    private javax.swing.JPanel toggleButtons;
    private javax.swing.JPanel workingArea;
    // End of variables declaration//GEN-END:variables
}
