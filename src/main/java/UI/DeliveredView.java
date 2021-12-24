package UI;
import Core.Delivery;
import Core.DeliveryFacade;
import Core.Product;
import Core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveredView extends JFrame implements ActionListener {

    //Core Variables
    Delivery delivery;
    Product product;
    User seller;
    User buyer;
    private DeliveryFacade deliveryFacade = DeliveryFacade.getDeliveryFacade();

    //View variables
    private Container contentPane = getContentPane();

    public DeliveredView(Delivery d) {

        //GLOBAL VARIABLES INIT
        this.delivery = d;
        this.seller = this.deliveryFacade.getSellerFromDelivery(d);
        this.buyer = this.deliveryFacade.getBuyerFromDelivery(d);
        this.product = this.deliveryFacade.getProductFromDelivery(d);

        //INIT
        this.setTitle("Your delivery");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //NORTH CONTENT
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(SwingConstants.NORTH_WEST));
        ImageIcon img = new ImageIcon(getClass().getResource("back.png"));
        Image newimg = img.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newimg);
        JButton backBtn = new JButton(finalImg);
        backBtn.setBackground(Color.WHITE);
        backBtn.addActionListener(this);
        north.add(backBtn);
        JLabel title = new JLabel("Delivery of Product : "+ product.getId());
        title.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
        north.add(title);

        //CENTER CONTENT
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        //First Grid
        GridLayout grid1 = new GridLayout(2,1, 0, 0);
        JPanel firstGrid = new JPanel();
        firstGrid.setLayout(grid1);
        ImageIcon sellerImg = new ImageIcon(getClass().getResource("seller.png"));
        Image newS = sellerImg.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon finalSeller = new ImageIcon(newS);
        JLabel sellerIcon = new JLabel(finalSeller);
        firstGrid.add(sellerIcon);
        JLabel sellerDesc = new JLabel("<html>From Seller : <br> Seller ID : "
                +seller.getId()+"</html>");
        sellerDesc.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        firstGrid.add(sellerDesc);
        center.add(firstGrid);

        //First Arrow
        ImageIcon arrow1 = new ImageIcon(getClass().getResource("next.png"));
        Image newArr = arrow1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon finalArrow = new ImageIcon(newArr);
        JLabel arrowIcon = new JLabel(finalArrow);
        arrowIcon.setBorder(BorderFactory.createEmptyBorder(0, 50, 150, 50));
        center.add(arrowIcon);

        //Second Grid
        GridLayout grid2 = new GridLayout(2,1, 0, 0);
        JPanel secondGrid = new JPanel();
        secondGrid.setLayout(grid2);
        ImageIcon productImg = new ImageIcon(getClass().getResource("product.png"));
        Image newP = productImg.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon finalProduct = new ImageIcon(newP);
        JLabel productIcon = new JLabel(finalProduct);
        secondGrid.add(productIcon);
        JLabel productDesc = new JLabel("<html>Product Information : <br> Product ID : "
                +product.getId()+"</html>");
        productDesc.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        secondGrid.add(productDesc);
        center.add(secondGrid);

        //Second Arrow
        ImageIcon arrow2 = new ImageIcon(getClass().getResource("next.png"));
        Image newArr2 = arrow2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon finalArrow2 = new ImageIcon(newArr2);
        JLabel arrowIcon2 = new JLabel(finalArrow2);
        arrowIcon2.setBorder(BorderFactory.createEmptyBorder(0, 50, 150, 50));
        center.add(arrowIcon2);

        //Third Grid
        GridLayout grid3 = new GridLayout(2,1, 0, 0);
        JPanel thirdGrid = new JPanel();
        thirdGrid.setLayout(grid3);
        ImageIcon buyerImg = new ImageIcon(getClass().getResource("buyer.png"));
        Image newB = buyerImg.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon finalBuyer = new ImageIcon(newB);
        JLabel buyerIcon = new JLabel(finalBuyer);
        thirdGrid.add(buyerIcon);
        JLabel buyerDesc = new JLabel("<html>To Buyer : <br> Buyer ID : "
                +buyer.getId()+"</html>");
        buyerDesc.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        thirdGrid.add(buyerDesc);
        center.add(thirdGrid);

        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String[] args){
        DeliveredView dv = new DeliveredView(new Delivery(2,1,2,1,true));
    }
}
