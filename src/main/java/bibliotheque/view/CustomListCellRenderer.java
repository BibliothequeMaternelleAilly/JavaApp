
package bibliotheque.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

/**
 *
 * @author shiro
 */
public class CustomListCellRenderer implements ListCellRenderer {

    private final JLabel lblCell = new JLabel("……………………………………………………", JLabel.LEFT);
    private final Border lineBorder = BorderFactory.createLineBorder(new Color(237,146,21), 1),
                         emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        if (isSelected) {
            lblCell.setOpaque(true);
            lblCell.setForeground(new Color(254,247,189));
            lblCell.setBackground(new Color(249,176,74));
            lblCell.setBorder(lineBorder);
        } else {
            lblCell.setOpaque(false);
            lblCell.setForeground(new Color(49,24,13));
            lblCell.setBorder(emptyBorder);
        }
        
        return lblCell;
    }
    
}
