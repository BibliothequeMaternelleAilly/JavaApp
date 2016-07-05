
package bibliotheque.view;

import bibliotheque.model.DBConnection;
import java.awt.CardLayout;
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
        try {
            maritime = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("MaritimeTropicalNeue.ttf"));
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
        jSeparator1 = new javax.swing.JSeparator();
        toggleButtons = new javax.swing.JPanel();
        TB_card1 = new javax.swing.JToggleButton();
        TB_card2 = new javax.swing.JToggleButton();
        TB_card3 = new javax.swing.JToggleButton();
        TB_card4 = new javax.swing.JToggleButton();
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
        L_title_tab1 = new javax.swing.JLabel();
        controls_tab1 = new javax.swing.JPanel();
        fields_tab1 = new javax.swing.JPanel();
        P_fields_tab1_top = new javax.swing.JPanel();
        L_fields_tab1_bookTitle = new javax.swing.JLabel();
        L_fields_tab1_name = new javax.swing.JLabel();
        P_fields_tab1_nameFields = new javax.swing.JPanel();
        SP_pupilList = new javax.swing.JScrollPane();
        L_pupilList = new javax.swing.JList<>();
        P_tab1_nameFields_name = new javax.swing.JTextField();
        P_tab1_nameFields_surname = new javax.swing.JTextField();
        P_fields_tab1_btm = new javax.swing.JPanel();
        B_fields_tab1_validate = new javax.swing.JButton();
        scan_tab1 = new javax.swing.JPanel();
        F_paging_scan_tab1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        P_scanFrame_tab1 = new javax.swing.JPanel();
        L_scanFrame_title_tab1 = new javax.swing.JLabel();
        P_scanFrame_controls_tab1 = new javax.swing.JPanel();
        FTF_barCode_tab1 = new javax.swing.JFormattedTextField();
        B_validate_tab1 = new javax.swing.JButton();
        tab2 = new javax.swing.JPanel();
        scan_tab2 = new javax.swing.JPanel();
        F_paging_scan_tab2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        P_scanFrame_tab2 = new javax.swing.JPanel();
        L_scanFrame_title_tab2 = new javax.swing.JLabel();
        P_scanFrame_controls_tab2 = new javax.swing.JPanel();
        FTF_barCode_tab2 = new javax.swing.JFormattedTextField();
        B_validate_tab2 = new javax.swing.JButton();
        L_title_tab2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel2 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
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
        L_title.setMaximumSize(new java.awt.Dimension(1243, 17));
        L_title.setMinimumSize(new java.awt.Dimension(1243, 17));
        workingArea.add(L_title, java.awt.BorderLayout.NORTH);

        controls.setOpaque(false);
        controls.setPreferredSize(new Dimension(workingArea.getPreferredSize().width, workingArea.getPreferredSize().height-L_title.getPreferredSize().height));
        controls.setLayout(new java.awt.BorderLayout());

        jSeparator1.setBackground(new java.awt.Color(254, 226, 165));
        jSeparator1.setForeground(new java.awt.Color(254, 226, 165));
        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator1.setMinimumSize(new java.awt.Dimension(4, 1));
        jSeparator1.setPreferredSize(new java.awt.Dimension(4, 1));
        controls.add(jSeparator1, java.awt.BorderLayout.NORTH);

        toggleButtons.setAutoscrolls(true);
        toggleButtons.setOpaque(false);
        toggleButtons.setPreferredSize(new Dimension((int) Math.round(controls.getPreferredSize().width*0.1), controls.getPreferredSize().height));
        toggleButtons.setRequestFocusEnabled(false);
        toggleButtons.setLayout(new javax.swing.BoxLayout(toggleButtons, javax.swing.BoxLayout.PAGE_AXIS));

        TB_card1.setBackground(new java.awt.Color(254, 172, 59));
        TB_card1.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.34)));
        TB_card1.setForeground(new java.awt.Color(254, 226, 165));
        TB_card1.setText("Emprunter");
        TB_card1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 172, 59), 4));
        TB_card1.setContentAreaFilled(false);
        TB_card1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_card1.setFocusPainted(false);
        TB_card1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_card1.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_card1.setMinimumSize(new java.awt.Dimension(0, 0));
        TB_card1.setName("card1"); // NOI18N
        toggleButtons.add(TB_card1);

        TB_card2.setBackground(new java.awt.Color(255, 97, 54));
        TB_card2.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.4)));
        TB_card2.setForeground(new java.awt.Color(254, 226, 165));
        TB_card2.setText("Rendre");
        TB_card2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 97, 54), 4));
        TB_card2.setContentAreaFilled(false);
        TB_card2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_card2.setFocusPainted(false);
        TB_card2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_card2.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_card2.setMinimumSize(new java.awt.Dimension(0, 0));
        TB_card2.setName("card2"); // NOI18N
        toggleButtons.add(TB_card2);

        TB_card3.setBackground(new java.awt.Color(253, 59, 99));
        TB_card3.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5)));
        TB_card3.setForeground(new java.awt.Color(254, 226, 165));
        TB_card3.setText("Éleves");
        TB_card3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(253, 59, 99), 4));
        TB_card3.setContentAreaFilled(false);
        TB_card3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_card3.setFocusPainted(false);
        TB_card3.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_card3.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_card3.setMinimumSize(new java.awt.Dimension(0, 0));
        TB_card3.setName("card3"); // NOI18N
        toggleButtons.add(TB_card3);

        TB_card4.setBackground(new java.awt.Color(218, 94, 238));
        TB_card4.setFont(clearLine.deriveFont((float) Math.round(toggleButtons.getPreferredSize().width*0.5)));
        TB_card4.setForeground(new java.awt.Color(254, 226, 165));
        TB_card4.setText("Livres");
        TB_card4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 94, 238), 4));
        TB_card4.setContentAreaFilled(false);
        TB_card4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_card4.setFocusPainted(false);
        TB_card4.setMargin(new java.awt.Insets(1, 1, 1, 1));
        TB_card4.setMaximumSize(new Dimension(toggleButtons.getPreferredSize().width, toggleButtons.getPreferredSize().width));
        TB_card4.setMinimumSize(new java.awt.Dimension(0, 0));
        TB_card4.setName("card4"); // NOI18N
        toggleButtons.add(TB_card4);

        controls.add(toggleButtons, java.awt.BorderLayout.LINE_START);

        mainMenuButtons.setBackground(new java.awt.Color(49, 24, 13));
        mainMenuButtons.setPreferredSize(toggleButtons.getPreferredSize());
        mainMenuButtons.setLayout(new javax.swing.BoxLayout(mainMenuButtons, javax.swing.BoxLayout.PAGE_AXIS));

        B_webSite.setBackground(new java.awt.Color(255, 78, 0));
        B_webSite.setFont(glyphicons.deriveFont((float) Math.round(mainMenuButtons.getPreferredSize().width*0.60)));
        B_webSite.setForeground(new java.awt.Color(254, 226, 165));
        B_webSite.setText("\uE135");
        B_webSite.setToolTipText("Aller sur le site internet");
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

        tabGroups.add(defaultTab, "card0");

        tab1.setBackground(new java.awt.Color(254, 172, 59));
        tab1.setLayout(new java.awt.BorderLayout());

        L_title_tab1.setFont(clearLine.deriveFont((float) Math.round(defaultTab.getPreferredSize().height *0.12)));
        L_title_tab1.setForeground(new java.awt.Color(255, 233, 184));
        L_title_tab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title_tab1.setText("Emprunter un livre");
        L_title_tab1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        L_title_tab1.setMinimumSize(new java.awt.Dimension(0, 0));
        L_title_tab1.setPreferredSize(new Dimension(P_titles.getPreferredSize().width, (int) Math.round(P_titles.getPreferredSize().height/2)));
        L_title_tab1.setRequestFocusEnabled(false);
        tab1.add(L_title_tab1, java.awt.BorderLayout.PAGE_START);

        controls_tab1.setOpaque(false);
        controls_tab1.setPreferredSize(new Dimension(200,0));
        controls_tab1.setLayout(new java.awt.CardLayout());

        fields_tab1.setForeground(new java.awt.Color(49, 20, 13));
        fields_tab1.setToolTipText("");
        fields_tab1.setOpaque(false);
        fields_tab1.setPreferredSize(new Dimension(200,200));
        fields_tab1.setLayout(new javax.swing.BoxLayout(fields_tab1, javax.swing.BoxLayout.PAGE_AXIS));

        P_fields_tab1_top.setBackground(new java.awt.Color(254, 247, 189));
        P_fields_tab1_top.setLayout(new javax.swing.BoxLayout(P_fields_tab1_top, javax.swing.BoxLayout.PAGE_AXIS));

        L_fields_tab1_bookTitle.setFont(maritime.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.1)));
        L_fields_tab1_bookTitle.setForeground(fields_tab1.getForeground());
        L_fields_tab1_bookTitle.setText("Livre");
        P_fields_tab1_top.add(L_fields_tab1_bookTitle);

        L_fields_tab1_name.setFont(maritime.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.05)));
        L_fields_tab1_name.setForeground(fields_tab1.getForeground());
        L_fields_tab1_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_fields_tab1_name.setText("Nom et prénom de l'emprunteur:");
        L_fields_tab1_name.setMaximumSize(new java.awt.Dimension(32767, 17));
        P_fields_tab1_top.add(L_fields_tab1_name);

        P_fields_tab1_nameFields.setAutoscrolls(true);
        P_fields_tab1_nameFields.setOpaque(false);
        P_fields_tab1_nameFields.setPreferredSize(new java.awt.Dimension(0, 0));

        SP_pupilList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 24, 13)), "Liste des élèves", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, L_fields_tab1_name.getFont().deriveFont((float) Math.round(L_fields_tab1_name.getFont().getSize()*0.9)), fields_tab1.getForeground()));
        SP_pupilList.setForeground(fields_tab1.getForeground());
        SP_pupilList.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        SP_pupilList.setOpaque(false);

        L_pupilList.setBackground(new java.awt.Color(254, 249, 189));
        L_pupilList.setFont(L_fields_tab1_name.getFont().deriveFont((float) Math.round(L_fields_tab1_name.getFont().getSize()*0.7)));
        L_pupilList.setForeground(fields_tab1.getForeground());
        L_pupilList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "……………………………………………………" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        L_pupilList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        L_pupilList.setCellRenderer(new CustomListCellRenderer());
        L_pupilList.setVisibleRowCount(4);
        SP_pupilList.setViewportView(L_pupilList);

        P_fields_tab1_nameFields.add(SP_pupilList);

        P_tab1_nameFields_name.setBackground(new java.awt.Color(249, 176, 74));
        P_tab1_nameFields_name.setColumns(15);
        P_tab1_nameFields_name.setFont(L_fields_tab1_name.getFont().deriveFont((float) Math.round(L_fields_tab1_name.getFont().getSize()*0.7)));
        P_tab1_nameFields_name.setForeground(fields_tab1.getForeground());
        P_tab1_nameFields_name.setText("NOM");
        P_tab1_nameFields_name.setBorder(javax.swing.BorderFactory.createLineBorder(fields_tab1.getForeground()));
        P_tab1_nameFields_name.setCaretColor(new java.awt.Color(49, 24, 13));
        P_tab1_nameFields_name.setCaretPosition(0);
        P_tab1_nameFields_name.setOpaque(false);
        P_fields_tab1_nameFields.add(P_tab1_nameFields_name);

        P_tab1_nameFields_surname.setBackground(new java.awt.Color(249, 176, 74));
        P_tab1_nameFields_surname.setColumns(15);
        P_tab1_nameFields_surname.setFont(L_fields_tab1_name.getFont().deriveFont((float) Math.round(L_fields_tab1_name.getFont().getSize()*0.7)));
        P_tab1_nameFields_surname.setForeground(fields_tab1.getForeground());
        P_tab1_nameFields_surname.setText("Prénom");
        P_tab1_nameFields_surname.setBorder(javax.swing.BorderFactory.createLineBorder(fields_tab1.getForeground()));
        P_tab1_nameFields_surname.setCaretColor(new java.awt.Color(49, 24, 13));
        P_tab1_nameFields_surname.setCaretPosition(0);
        P_tab1_nameFields_surname.setOpaque(false);
        P_fields_tab1_nameFields.add(P_tab1_nameFields_surname);

        P_fields_tab1_top.add(P_fields_tab1_nameFields);

        fields_tab1.add(P_fields_tab1_top);

        P_fields_tab1_btm.setOpaque(false);

        B_fields_tab1_validate.setBackground(new java.awt.Color(123, 178, 40));
        B_fields_tab1_validate.setFont(L_fields_tab1_name.getFont());
        B_fields_tab1_validate.setForeground(fields_tab1.getForeground());
        B_fields_tab1_validate.setText("Emprunter");
        B_fields_tab1_validate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 150, 0)));
        B_fields_tab1_validate.setContentAreaFilled(false);
        B_fields_tab1_validate.setFocusPainted(false);
        P_fields_tab1_btm.add(B_fields_tab1_validate);

        fields_tab1.add(P_fields_tab1_btm);

        controls_tab1.add(fields_tab1, "card2");

        scan_tab1.setForeground(new java.awt.Color(49, 20, 13));
        scan_tab1.setOpaque(false);
        scan_tab1.setLayout(new java.awt.GridLayout(3, 0));
        scan_tab1.add(F_paging_scan_tab1);

        P_scanFrame_tab1.setBackground(new java.awt.Color(254, 247, 189));
        P_scanFrame_tab1.setForeground(new java.awt.Color(49, 20, 13));
        P_scanFrame_tab1.setLayout(new javax.swing.BoxLayout(P_scanFrame_tab1, javax.swing.BoxLayout.PAGE_AXIS));

        L_scanFrame_title_tab1.setFont(maritime.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.05)));
        L_scanFrame_title_tab1.setForeground(scan_tab1.getForeground());
        L_scanFrame_title_tab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_scanFrame_title_tab1.setText("Veuillez scanner le code barre du livre ou le taper dans la zone de texte:");
        P_scanFrame_tab1.add(L_scanFrame_title_tab1);

        P_scanFrame_controls_tab1.setOpaque(false);
        P_scanFrame_controls_tab1.setPreferredSize(new Dimension(P_scanFrame_tab1.getPreferredSize().width, (int) Math.round(P_scanFrame_tab1.getPreferredSize().height*0.4)));

        FTF_barCode_tab1.setBackground(new java.awt.Color(249, 176, 74));
        FTF_barCode_tab1.setBorder(javax.swing.BorderFactory.createLineBorder(scan_tab1.getForeground()));
        FTF_barCode_tab1.setColumns(13);
        FTF_barCode_tab1.setForeground(new java.awt.Color(254, 247, 189));
        try {
            FTF_barCode_tab1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FTF_barCode_tab1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FTF_barCode_tab1.setFont(maritime.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.07)));
        FTF_barCode_tab1.setMargin(new java.awt.Insets(0, 0, 500, 0));
        P_scanFrame_controls_tab1.add(FTF_barCode_tab1);

        B_validate_tab1.setFont(glyphicons.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.13)));
        B_validate_tab1.setForeground(new java.awt.Color(123, 178, 40));
        B_validate_tab1.setText("\uE084");
        B_validate_tab1.setToolTipText("Valider");
        B_validate_tab1.setBorderPainted(false);
        B_validate_tab1.setContentAreaFilled(false);
        B_validate_tab1.setEnabled(false);
        B_validate_tab1.setFocusPainted(false);
        P_scanFrame_controls_tab1.add(B_validate_tab1);

        P_scanFrame_tab1.add(P_scanFrame_controls_tab1);

        scan_tab1.add(P_scanFrame_tab1);

        controls_tab1.add(scan_tab1, "card1");

        tab1.add(controls_tab1, java.awt.BorderLayout.CENTER);

        tabGroups.add(tab1, "card1");

        tab2.setBackground(new java.awt.Color(255, 97, 54));
        tab2.setLayout(new java.awt.BorderLayout());

        scan_tab2.setForeground(new java.awt.Color(49, 20, 13));
        scan_tab2.setOpaque(false);
        scan_tab2.setLayout(new java.awt.GridLayout(3, 0));
        scan_tab2.add(F_paging_scan_tab2);

        P_scanFrame_tab2.setBackground(new java.awt.Color(254, 205, 189));
        P_scanFrame_tab2.setLayout(new javax.swing.BoxLayout(P_scanFrame_tab2, javax.swing.BoxLayout.PAGE_AXIS));

        L_scanFrame_title_tab2.setFont(maritime.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.05)));
        L_scanFrame_title_tab2.setForeground(scan_tab2.getForeground());
        L_scanFrame_title_tab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_scanFrame_title_tab2.setText("Veuillez scanner le code barre du livre ou le taper dans la zone de texte:");
        P_scanFrame_tab2.add(L_scanFrame_title_tab2);

        P_scanFrame_controls_tab2.setOpaque(false);
        P_scanFrame_controls_tab2.setPreferredSize(new Dimension(P_scanFrame_tab1.getPreferredSize().width, (int) Math.round(P_scanFrame_tab1.getPreferredSize().height*0.4)));

        FTF_barCode_tab2.setBackground(new java.awt.Color(253, 105, 55));
        FTF_barCode_tab2.setBorder(javax.swing.BorderFactory.createLineBorder(scan_tab2.getForeground()));
        FTF_barCode_tab2.setColumns(13);
        FTF_barCode_tab2.setForeground(new java.awt.Color(254, 226, 189));
        try {
            FTF_barCode_tab2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FTF_barCode_tab2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FTF_barCode_tab2.setFont(maritime.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.07)));
        P_scanFrame_controls_tab2.add(FTF_barCode_tab2);

        B_validate_tab2.setFont(glyphicons.deriveFont((float) Math.round(tabGroups.getPreferredSize().height*0.13)));
        B_validate_tab2.setForeground(new java.awt.Color(123, 178, 40));
        B_validate_tab2.setText("\uE084");
        B_validate_tab2.setToolTipText("Valider");
        B_validate_tab2.setBorderPainted(false);
        B_validate_tab2.setContentAreaFilled(false);
        B_validate_tab2.setEnabled(false);
        B_validate_tab2.setFocusPainted(false);
        P_scanFrame_controls_tab2.add(B_validate_tab2);

        P_scanFrame_tab2.add(P_scanFrame_controls_tab2);

        scan_tab2.add(P_scanFrame_tab2);

        tab2.add(scan_tab2, java.awt.BorderLayout.CENTER);

        L_title_tab2.setFont(clearLine.deriveFont((float) Math.round(defaultTab.getPreferredSize().height *0.12)));
        L_title_tab2.setForeground(new java.awt.Color(253, 212, 198));
        L_title_tab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title_tab2.setText("Rendre un livre");
        L_title_tab2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        L_title_tab2.setMinimumSize(new java.awt.Dimension(0, 0));
        L_title_tab2.setPreferredSize(new Dimension(P_titles.getPreferredSize().width, (int) Math.round(P_titles.getPreferredSize().height/2)));
        L_title_tab2.setRequestFocusEnabled(false);
        tab2.add(L_title_tab2, java.awt.BorderLayout.PAGE_START);

        tabGroups.add(tab2, "card2");

        tab3.setBackground(new java.awt.Color(253, 59, 99));
        tab3.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setBackground(tab3.getBackground());

        jScrollPane1.setOpaque(false);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setOpaque(false);

        jLabel1.setText("Rechercher un élève");
        jPanel2.add(jLabel1);

        jTextField1.setText("jTextField1");
        jPanel2.add(jTextField1);

        jButton1.setText("jButton1");
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jSeparator2, java.awt.BorderLayout.NORTH);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(4, 2));

        jLabel3.setText("jLabel3");
        jPanel4.add(jLabel3);
        jPanel4.add(filler2);

        jLabel2.setText("jLabel2");
        jPanel4.add(jLabel2);
        jPanel4.add(filler1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel4.add(jScrollPane2);

        jPanel5.setOpaque(false);

        jButton2.setText("jButton2");
        jPanel5.add(jButton2);

        jPanel4.add(jPanel5);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        jSplitPane1.setRightComponent(jPanel1);

        tab3.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        tabGroups.add(tab3, "card3");

        tab4.setBackground(new java.awt.Color(218, 94, 238));
        tabGroups.add(tab4, "card4");

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

    public JToggleButton getTB_card1() {
        return TB_card1;
    }

    public JToggleButton getTB_card2() {
        return TB_card2;
    }

    public JToggleButton getTB_card3() {
        return TB_card3;
    }

    public JToggleButton getTB_card4() {
        return TB_card4;
    }

    public CardLayout getTabGroupsLayout() {
        return (CardLayout) tabGroups.getLayout();
    }

    public JPanel getTabGroups() {
        return tabGroups;
    }

    public JPanel getToggleButtons() {
        return toggleButtons;
    }

    public JButton getB_webSite() {
        return B_webSite;
    }
    
    
    private Font littleBird;
    private Font clearLine;
    private Font glyphicons;
    private Font maritime;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_fields_tab1_validate;
    private javax.swing.JButton B_help;
    private javax.swing.JButton B_quit;
    private javax.swing.JButton B_settings;
    private javax.swing.JButton B_validate_tab1;
    private javax.swing.JButton B_validate_tab2;
    private javax.swing.JButton B_webSite;
    private javax.swing.JFormattedTextField FTF_barCode_tab1;
    private javax.swing.JFormattedTextField FTF_barCode_tab2;
    private javax.swing.Box.Filler F_paging_scan_tab1;
    private javax.swing.Box.Filler F_paging_scan_tab2;
    private javax.swing.JLabel L_fields_tab1_bookTitle;
    private javax.swing.JLabel L_fields_tab1_name;
    private javax.swing.JList<String> L_pupilList;
    private javax.swing.JLabel L_scanFrame_title_tab1;
    private javax.swing.JLabel L_scanFrame_title_tab2;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_title1;
    private javax.swing.JLabel L_title2;
    private javax.swing.JLabel L_title_tab1;
    private javax.swing.JLabel L_title_tab2;
    private javax.swing.JPanel P_fields_tab1_btm;
    private javax.swing.JPanel P_fields_tab1_nameFields;
    private javax.swing.JPanel P_fields_tab1_top;
    private javax.swing.JPanel P_scanFrame_controls_tab1;
    private javax.swing.JPanel P_scanFrame_controls_tab2;
    private javax.swing.JPanel P_scanFrame_tab1;
    private javax.swing.JPanel P_scanFrame_tab2;
    private javax.swing.JTextField P_tab1_nameFields_name;
    private javax.swing.JTextField P_tab1_nameFields_surname;
    private javax.swing.JPanel P_titles;
    private javax.swing.JScrollPane SP_pupilList;
    private javax.swing.JToggleButton TB_card1;
    private javax.swing.JToggleButton TB_card2;
    private javax.swing.JToggleButton TB_card3;
    private javax.swing.JToggleButton TB_card4;
    private bibliotheque.view.BgPanel background;
    private javax.swing.JPanel controls;
    private javax.swing.JPanel controls_tab1;
    private javax.swing.JPanel defaultTab;
    private javax.swing.JPanel fields_tab1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainMenuButtons;
    private javax.swing.JPanel scan_tab1;
    private javax.swing.JPanel scan_tab2;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tabGroups;
    private javax.swing.JPanel toggleButtons;
    private javax.swing.JPanel workingArea;
    // End of variables declaration//GEN-END:variables
}
