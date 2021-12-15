package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.WildcardType;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.DeliveryFacade;
import Core.LoginFacade;

public class DeliveryView extends JFrame implements ActionListener {

    DeliveryFacade deliveryFacade = new DeliveryFacade();
    private Container contentPane = getContentPane();
    private BufferedImage image;


    public DeliveryView() {

        //INIT
        this.setTitle("Delivering your product(s)...");
        setVisible(true);
        pack();

        //ICON management
        ImageIcon img = new ImageIcon(getClass().getResource("iconCourir.png"));
        JLabel wIcon = new JLabel(img);
        JPanel j= new JPanel();
        j.add(wIcon);
        contentPane.add(j, BorderLayout.NORTH);



    }

    /**
     * Deliver the product from the buyer (me) to the seller (DeliveryFacade) 
     */
    public void deliver() { 
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) {
        DeliveryView del = new DeliveryView();
    }
}
