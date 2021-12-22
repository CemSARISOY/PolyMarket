package UI;

import Core.Delivery;
import Core.DeliveryFacade;
import Core.Product;
import Core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeliveryView extends JFrame implements ActionListener {

    //Core variables
    private DeliveryFacade deliveryFacade = DeliveryFacade.getDeliveryFacade();
    private Delivery delivery;
    private User buyer;
    private User seller;
    private Product product;

    //View variables
    private Container contentPane = getContentPane();

    public DeliveryView(User seller, User buyer, Product p) {

        //GLOBAL VARIABLES INIT
        this.seller = seller;
        this.buyer = buyer;
        this.product = p;

        //INIT
        this.setTitle("Delivering your product(s)...");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Grid
        GridLayout grid = new GridLayout(3,1, 0, 0);
        JPanel gridLayout = new JPanel();
        gridLayout.setLayout(grid);

        //Text management
        JLabel text = new JLabel("Veuillez patienter, votre NFT est en cours de livraison...", SwingConstants.CENTER);
        text.setBorder(BorderFactory.createEmptyBorder(125, 0, 50, 0));
        gridLayout.add(text);

        //Run icon management
        ImageIcon img = new ImageIcon(getClass().getResource("iconCourir.png"));
        Image newimg = img.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newimg);
        JLabel wIcon = new JLabel(finalImg);
        gridLayout.add(wIcon);

        //Load icon management
        ImageIcon barre = new ImageIcon(getClass().getResource("barre.png"));
        Image newImg2 = barre.getImage().getScaledInstance(300,200, Image.SCALE_SMOOTH);
        ImageIcon finalBarre = new ImageIcon(newImg2);
        JLabel barreLabel = new JLabel(finalBarre);
        gridLayout.add(barreLabel);

        //Final config
        JPanel wrapper = new JPanel();
        wrapper.add( gridLayout );
        contentPane.add(wrapper, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Calls automatically deliver
        deliver();
    }

    /**
     * Deliver the product from the buyer (me) to the seller (DeliveryFacade) 
     */
    public void deliver() {
        try {
            //this.delivery =  this.deliveryFacade.deliver(this.buyer,this.seller,this.product);
            int res = JOptionPane.showOptionDialog(null, "Product well delivered !", "Information", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            while(res != 0 && res != -1){}
            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {
        User u1 = new User(2);
        User u2 = new User(3);
        ArrayList<Product> p1 = new ArrayList<Product>();
        p1.add(new Product(1));
        u1.setProducts(p1);
        u2.setProducts(p1);
        Product p2 = new Product(2);
        DeliveryView del = new DeliveryView(u1, u2, p2);
    }
}
