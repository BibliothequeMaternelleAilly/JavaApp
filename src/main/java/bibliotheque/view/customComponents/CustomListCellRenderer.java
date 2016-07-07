
package bibliotheque.view.customComponents;

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
    private Color background = new Color(249,176,74),
                  selectionForeground = new Color(254,247,189),
                  foreground = new Color(49,24,13);
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        Border lineBorder = BorderFactory.createLineBorder(selectionForeground, 1),
               emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        
        if (isSelected) {
            lblCell.setOpaque(true);
            lblCell.setForeground(selectionForeground);
            lblCell.setBackground(background);
            lblCell.setBorder(lineBorder);
        } else {
            lblCell.setOpaque(false);
            lblCell.setForeground(foreground);
            lblCell.setBorder(emptyBorder);
        }
        
        return lblCell;
    }

    public Color getBackground() {
        return background;
    }

    public Color getForeground() {
        return foreground;
    }

    public Color getSelectionForeground() {
        return selectionForeground;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public void setSelectionForeground(Color selectionForeground) {
        this.selectionForeground = selectionForeground;
    }  
    
}
