package UI.payment;

import javax.swing.*;
import javax.swing.border.*; 
import java.awt.*;  

class RoundedBorder extends JPanel implements Border {
        
    private int radius;
    
    RoundedBorder(int radius) {
        this.radius = radius;
    }
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }


    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x,y,width-1,height-1,5*radius,5*radius); 
        g.fillRoundRect(x,y,width-1,height-1,5*radius,5*radius);
        g.setColor(getBackground());
    }
}