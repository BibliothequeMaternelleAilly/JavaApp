
package bibliotheque.view.customComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author shiro
 */
public class CustomToggleButton extends JPanel {
    
    private boolean selected = false;
    private Color selectedColor, unselectedColor;
    private final JLabel text = new JLabel("ToggleButton");
    
    public CustomToggleButton() {
        super();
        setLayout(new java.awt.BorderLayout());
        unselectedColor = getBackground();
        selectedColor = getBackground().darker();
        text.setBorder(null);
        text.setOpaque(false);
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
    
    @Override
    public void setFont(Font font) {
        try {
            this.text.setFont(font);
        } catch (NullPointerException e) {
        }
        super.setFont(font);
    }
    
    @Override
    public void setForeground(Color fg) {
        try {
            this.text.setForeground(fg);
        } catch (NullPointerException e) {
        }
        super.setForeground(fg);
    }
}
