
package bibliotheque.view.customComponents;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author shiro
 */
public class CustomToggleButton extends JPanel {
    
    private boolean selected;
    private Color selectedColor, unselectedColor;
    private final JLabel text;
    
    public CustomToggleButton() {
        super();
        setLayout(new java.awt.BorderLayout());
        selected = false;
        unselectedColor = getBackground();
        selectedColor = getBackground().darker();
        text = new JLabel("ToggleButton");
        text.setForeground(getForeground());
        text.setBorder(null);
        text.setOpaque(true);
        text.setFont(getFont());
        text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        this.add(text, java.awt.BorderLayout.CENTER);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isOpaque()) {
            g.setColor(selected ? selectedColor:unselectedColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        text.repaint();
    }

    public void toggle() {
        selected = !selected;
        repaint();
        try {
            Thread.sleep(68);
        } catch(InterruptedException ie) {
        }
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
        repaint();
    }

    public Color getUnselectedColor() {
        return unselectedColor;
    }

    public void setUnselectedColor(Color unselectedColor) {
        this.unselectedColor = unselectedColor;
        repaint();
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
        repaint();
    }
}
