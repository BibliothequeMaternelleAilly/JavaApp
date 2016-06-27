
package bibliotheque.view;

import bibliotheque.model.DBConnection;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author shiro
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public MainFrame() {
        
        setTitle("Bibliothèque");
        try {
            littleBird = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("LittleBird.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(BgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clearLine = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("ClearLine.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(BgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            glyphicons = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("glyphicons.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new BgPanel();
        workingArea = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        controls = new javax.swing.JPanel();
        toggleButtons = new javax.swing.JPanel();
        TB_tab1 = new javax.swing.JToggleButton();
        TB_tab2 = new javax.swing.JToggleButton();
        TB_tab3 = new javax.swing.JToggleButton();
        TB_tab4 = new javax.swing.JToggleButton();
        mainMenuButtons = new javax.swing.JPanel();
        B_webSite = new javax.swing.JButton();
        B_settings = new javax.swing.JButton();
        B_help = new javax.swing.JButton();
        B_quit = new javax.swing.JButton();
        tabGroups = new javax.swing.JPanel();
        defaultTab = new javax.swing.JPanel();
        P_titles = new javax.swing.JPanel();
        L_title1 = new javax.swing.JLabel();
        L_title2 = new javax.swing.JLabel();
        tab1 = new javax.swing.JPanel();
        tab2 = new javax.swing.JPanel();
        tab3 = new javax.swing.JPanel();
        tab4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new Dimension((int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.75), (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.75)));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        background.setBackground(new java.awt.Color(91, 43, 5));
        setVisible(true);
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        getContentPane().add(background, java.awt.BorderLayout.CENTER);
        background.initBackground();
        background.repaint();
        background.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, (int) Math.round(background.getHeight()*0.075)));

        workingArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 226, 165)));
        workingArea.setOpaque(false);
        workingArea.setPreferredSize(new java.awt.Dimension(872, 491));
        workingArea.setPreferredSize(new Dimension((int) Math.round(background.getWidth()*0.85), (int) Math.round(background.getHeight()*0.85)+1));
        workingArea.setLayout(new java.awt.BorderLayout());

        L_title.setFont(littleBird.deriveFont((float) Math.round(workingArea.getPreferredSize().height*0.1)));
        L_title.setForeground(new java.awt.Color(253, 250, 206));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Bibliotheque de l'école maternelle");
        L_title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 226, 165)));
        L_title.setMaximumSize(new java.awt.Dimension(1243, 17));
        L_title.setMinimumSize(new java.awt.Dimension(1243, 17));
        workingArea.add(L_title, java.awt.BorderLayout.PAGE_START);

        controls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 226, 165)));
        controls.setOpaque(false);
        controls.setPreferredSize(new Dimension(workingArea.getPreferredSize().width, workingArea.getPreferredSize().height-L_title.getPreferredSize().height));
        controls.setLayout(new java.awt.BorderLayout());

        toggleButtons.setAutoscrolls(true);
        toggleButtons.setOpaque(false);
        toggleButtons.setPreferredSize(new Dimension((int) Math.round(controls.getPreferredSize().width*0.09), controls.getPreferredSize().height));
        toggleButtons.setLayout(new javax.swing.BoxLayout(toggleButtons, javax.swing.BoxLayout.PAGE_AXIS));

        TB_tab1.setBackground(new java.awt.Color(237, 146, 21));
        TB_tab1.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5)));
        TB_tab1.setForeground(new java.awt.Color(254, 226, 165));
        TB_tab1.setText("Tab1");
        TB_tab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 146, 21), 4));
        TB_tab1.setContentAreaFilled(false);
        TB_tab1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_tab1.setFocusPainted(false);
        TB_tab1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab1.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab1.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab1);

        TB_tab2.setBackground(new java.awt.Color(237, 66, 21));
        TB_tab2.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5)));
        TB_tab2.setForeground(new java.awt.Color(254, 226, 165));
        TB_tab2.setText("Tab2");
        TB_tab2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 66, 21), 4));
        TB_tab2.setContentAreaFilled(false);
        TB_tab2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_tab2.setFocusPainted(false);
        TB_tab2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab2.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab2.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab2);

        TB_tab3.setBackground(new java.awt.Color(237, 21, 66));
        TB_tab3.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5)));
        TB_tab3.setForeground(new java.awt.Color(254, 226, 165));
        TB_tab3.setText("Tab3");
        TB_tab3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 21, 66), 4));
        TB_tab3.setContentAreaFilled(false);
        TB_tab3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_tab3.setFocusPainted(false);
        TB_tab3.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab3.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab3.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab3);

        TB_tab4.setBackground(new java.awt.Color(208, 61, 199));
        TB_tab4.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5)));
        TB_tab4.setForeground(new java.awt.Color(254, 226, 165));
        TB_tab4.setText("Tab4");
        TB_tab4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 61, 199), 4));
        TB_tab4.setContentAreaFilled(false);
        TB_tab4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_tab4.setFocusPainted(false);
        TB_tab4.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_tab4.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_tab4.setMinimumSize(new java.awt.Dimension(0, 0));
        toggleButtons.add(TB_tab4);

        controls.add(toggleButtons, java.awt.BorderLayout.LINE_START);

        mainMenuButtons.setBackground(new java.awt.Color(49, 24, 13));
        mainMenuButtons.setPreferredSize(toggleButtons.getPreferredSize());
        mainMenuButtons.setLayout(new javax.swing.BoxLayout(mainMenuButtons, javax.swing.BoxLayout.PAGE_AXIS));

        B_webSite.setBackground(new java.awt.Color(255, 78, 0));
        B_webSite.setFont(glyphicons.deriveFont((float) Math.round(mainMenuButtons.getPreferredSize().width*0.60)));
        B_webSite.setForeground(new java.awt.Color(254, 226, 165));
        B_webSite.setText("\uE135");
        B_webSite.setToolTipText("Passer en mode plein écran");
        B_webSite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 24, 13), 7));
        B_webSite.setBorderPainted(false);
        B_webSite.setContentAreaFilled(false);
        B_webSite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_webSite.setFocusPainted(false);
        B_webSite.setMaximumSize(new java.awt.Dimension(32767, 32767));
        B_webSite.setPreferredSize(new Dimension(mainMenuButtons.getPreferredSize().width, mainMenuButtons.getPreferredSize().width));
        mainMenuButtons.add(B_webSite);

        B_settings.setBackground(new java.awt.Color(255, 78, 0));
        B_settings.setFont(glyphicons.deriveFont((float) Math.round(mainMenuButtons.getPreferredSize().width*0.60)));
        B_settings.setForeground(new java.awt.Color(254, 226, 165));
        B_settings.setText("\uE019");
        B_settings.setToolTipText("Paramètres");
        B_settings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 24, 13), 4));
        B_settings.setBorderPainted(false);
        B_settings.setContentAreaFilled(false);
        B_settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_settings.setFocusPainted(false);
        B_settings.setMaximumSize(new java.awt.Dimension(32767, 32767));
        B_settings.setPreferredSize(new Dimension(mainMenuButtons.getPreferredSize().width, mainMenuButtons.getPreferredSize().width));
        mainMenuButtons.add(B_settings);

        B_help.setBackground(new java.awt.Color(255, 78, 0));
        B_help.setFont(glyphicons.deriveFont((float) Math.round(mainMenuButtons.getPreferredSize().width*0.60)));
        B_help.setForeground(new java.awt.Color(254, 226, 165));
        B_help.setText("\uE085");
        B_help.setToolTipText("À propos…");
        B_help.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 24, 13), 4));
        B_help.setBorderPainted(false);
        B_help.setContentAreaFilled(false);
        B_help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_help.setFocusPainted(false);
        B_help.setMaximumSize(new java.awt.Dimension(32767, 32767));
        B_help.setPreferredSize(new Dimension(mainMenuButtons.getPreferredSize().width, mainMenuButtons.getPreferredSize().width));
        mainMenuButtons.add(B_help);

        B_quit.setBackground(new java.awt.Color(255, 78, 0));
        B_quit.setFont(glyphicons.deriveFont((float) Math.round(mainMenuButtons.getPreferredSize().width*0.60)));
        B_quit.setForeground(new java.awt.Color(254, 226, 165));
        B_quit.setText("\uE017");
        B_quit.setToolTipText("Quitter");
        B_quit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 24, 13), 4));
        B_quit.setBorderPainted(false);
        B_quit.setContentAreaFilled(false);
        B_quit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_quit.setFocusPainted(false);
        B_quit.setMaximumSize(new java.awt.Dimension(32767, 32767));
        B_quit.setPreferredSize(new Dimension(mainMenuButtons.getPreferredSize().width, mainMenuButtons.getPreferredSize().width));
        mainMenuButtons.add(B_quit);

        controls.add(mainMenuButtons, java.awt.BorderLayout.LINE_END);

        tabGroups.setOpaque(false);
        tabGroups.setPreferredSize(new Dimension(controls.getPreferredSize().width-2*toggleButtons.getPreferredSize().width, controls.getPreferredSize().height));
        tabGroups.setLayout(new java.awt.CardLayout());

        defaultTab.setOpaque(false);
        defaultTab.setPreferredSize(new Dimension(tabGroups.getPreferredSize().width, tabGroups.getPreferredSize().height));
        defaultTab.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, (int) Math.round(defaultTab.getPreferredSize().height*0.25)));

        P_titles.setMinimumSize(new java.awt.Dimension(861, 50));
        P_titles.setOpaque(false);
        P_titles.setPreferredSize(new java.awt.Dimension(600, 50));
        P_titles.setPreferredSize(new Dimension(defaultTab.getPreferredSize().width, (int) Math.round(defaultTab.getPreferredSize().height*0.31)));

        L_title1.setFont(clearLine.deriveFont((float) Math.round(defaultTab.getPreferredSize().height *0.12)));
        L_title1.setForeground(new java.awt.Color(254, 226, 165));
        L_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title1.setText("Bienvenue à la bibliotheque de l'école maternelle!");
        L_title1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        L_title1.setMinimumSize(new java.awt.Dimension(0, 0));
        L_title1.setPreferredSize(new Dimension(P_titles.getPreferredSize().width, (int) Math.round(P_titles.getPreferredSize().height/2)));
        L_title1.setRequestFocusEnabled(false);
        P_titles.add(L_title1);

        L_title2.setFont(clearLine.deriveFont((float) Math.round(defaultTab.getPreferredSize().height *0.10)));
        L_title2.setForeground(new java.awt.Color(254, 226, 165));
        L_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title2.setText("Cliquez sur un des onglets à gauche pour commencer");
        L_title2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        L_title2.setMinimumSize(new java.awt.Dimension(0, 0));
        L_title2.setPreferredSize(new Dimension(P_titles.getPreferredSize().width, (int) Math.round(P_titles.getPreferredSize().height/2)));
        P_titles.add(L_title2);

        defaultTab.add(P_titles);

        tabGroups.add(defaultTab, "card6");

        tab1.setBackground(new java.awt.Color(237, 146, 21));
        tabGroups.add(tab1, "card2");

        tab2.setBackground(new java.awt.Color(237, 66, 21));
        tabGroups.add(tab2, "card3");

        tab3.setBackground(new java.awt.Color(237, 21, 66));
        tabGroups.add(tab3, "card4");

        tab4.setBackground(new java.awt.Color(208, 61, 199));
        tabGroups.add(tab4, "card5");

        controls.add(tabGroups, java.awt.BorderLayout.CENTER);

        workingArea.add(controls, java.awt.BorderLayout.CENTER);

        background.add(workingArea);
        background.validate();

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            DBConnection.getInstance().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    public JButton getB_help() {
        return B_help;
    }

    public JButton getB_quit() {
        return B_quit;
    }

    public JButton getB_settings() {
        return B_settings;
    }

    public JToggleButton getTB_tab1() {
        return TB_tab1;
    }

    public JToggleButton getTB_tab2() {
        return TB_tab2;
    }

    public JToggleButton getTB_tab3() {
        return TB_tab3;
    }

    public JToggleButton getTB_tab4() {
        return TB_tab4;
    }

    public JPanel getDefaultTab() {
        return defaultTab;
    }

    public JPanel getTab1() {
        return tab1;
    }

    public JPanel getTab2() {
        return tab2;
    }

    public JPanel getTab3() {
        return tab3;
    }

    public JPanel getTab4() {
        return tab4;
    }

    public JPanel getToggleButtons() {
        return toggleButtons;
    }
    
    
    private Font littleBird;
    private Font clearLine;
    private Font glyphicons;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_help;
    private javax.swing.JButton B_quit;
    private javax.swing.JButton B_settings;
    private javax.swing.JButton B_webSite;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_title1;
    private javax.swing.JLabel L_title2;
    private javax.swing.JPanel P_titles;
    private javax.swing.JToggleButton TB_tab1;
    private javax.swing.JToggleButton TB_tab2;
    private javax.swing.JToggleButton TB_tab3;
    private javax.swing.JToggleButton TB_tab4;
    private bibliotheque.view.BgPanel background;
    private javax.swing.JPanel controls;
    private javax.swing.JPanel defaultTab;
    private javax.swing.JPanel mainMenuButtons;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tabGroups;
    private javax.swing.JPanel toggleButtons;
    private javax.swing.JPanel workingArea;
    // End of variables declaration//GEN-END:variables
}
