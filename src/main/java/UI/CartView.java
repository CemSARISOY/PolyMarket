package UI;

import Core.Product;
import Core.ProductCategory;
import Core.User;
import Core.UserFacade;
import Core.Wishlist;
import Persist.AbstractFactoryDao;
import UI.payment.PaymentView;
import Core.CartFacade;
import Core.LoginFacade;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class CartView extends JFrame implements ActionListener {

    //Core variables
    public CartFacade cartFacade;
    private ArrayList<Product> products;
    private User user; 
 
    //View variables
    public Container contentPane = getContentPane();

    public CartView(User u){

        cartFacade = CartFacade.getCartFacade();
        //GLOBAL VARIABLES INIT
        try { 
            this.products = (ArrayList<Product>) cartFacade.getItemsInCart(); 
            this.user = u;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 

        //NORTH CONTENT
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(SwingConstants.NORTH_WEST));
        ImageIcon back = new ImageIcon(getClass().getResource("back.png"));
        Image newBack = back.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
        ImageIcon finalBack = new ImageIcon(newBack);
     /*   JButton backBtn = new JButton(finalBack);
        backBtn.setBackground(Color.WHITE);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListWishlistsView listWishlistsView = new ListWishlistsView(user);
            }
        });
        
        north.add(backBtn);
        
        */
     
        /*JLabel title = new JLabel(this.wishlist.getTitle()+"'s Wishlist");
        title.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
        north.add(title);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));*/

        //CENTER CONTENT
        //Center config
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,200,200,200));
        center.setLayout(new GridLayout(0,1));

        //Products management
        for(var i =0; i< products.size(); i++) {

            //Main Button
            JPanel prodPanel =new JPanel();
            JLabel prodDesc= new JLabel(products.get(i).getBody());
            prodDesc.setPreferredSize(new Dimension(500,75));
            prodDesc.setOpaque(true);
            prodDesc.setBackground(Color.darkGray);
            prodDesc.setForeground(Color.white);

            JPanel btnPanel = new JPanel();
            btnPanel.add(prodDesc);
            btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

            //Left Label infos
            JLabel prodInfo = new JLabel("<html> Product id : "+products.get(i).getId()+"<br>" +
                    "Name : "+products.get(i).getName()+"<br>"+
                    "Price : "+products.get(i).getPrice()+"<br>");
            prodInfo.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

            //Right panel
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
            //DELETE BUTTON
            ImageIcon img = new ImageIcon(getClass().getResource("poubelle.png"));
            Image newimg = img.getImage().getScaledInstance(15,15, Image.SCALE_SMOOTH);
            ImageIcon finalImg = new ImageIcon(newimg);
            JButton delBtn = new JButton(finalImg);
            delBtn.setName(String.valueOf(products.get(i).getId()));
            delBtn.setBackground(Color.WHITE);
            delBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton but = (JButton) e.getSource();
                    int input = JOptionPane.showConfirmDialog(null,
                            "Do you really want to delete this product ?",
                            "Select an option",
                            JOptionPane.OK_CANCEL_OPTION);
                    while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION) {}
                    if(input == 0) {
                    	System.out.println("hello there");
                        try {
                        	cartFacade.deleteProductById(Integer.parseInt(but.getName()));
                        	System.out.println(cartFacade.getNbItems());
                            dispose();
                            CartView cartView = new CartView(user);
                        }
                        catch (Exception e2) {
                            JOptionPane.showMessageDialog(null, e2.getMessage());
                        }
                    }
                }
            }); 

            //Adding to right panel
            JPanel addPanel = new JPanel();
            addPanel.setBorder(BorderFactory.createEmptyBorder(0,47,10,0));
            rightPanel.add(addPanel);
            rightPanel.add(delBtn);

            //Grouping
            prodPanel.add(prodInfo);
            prodPanel.add(btnPanel);
            prodPanel.add(rightPanel);
            prodPanel.setBorder(new LineBorder(Color.black, 1, true));
            center.add(prodPanel);
        }

        //Center Scrollable
        JScrollPane scroll = new JScrollPane(center,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //SOUTH
        JPanel south = new JPanel();
        south.setBorder(BorderFactory.createEmptyBorder(40,0,40,0));
        JButton addToCart = new JButton("PAY");
        addToCart.setForeground(Color.white);
        addToCart.setBackground(Color.black);
        addToCart.addActionListener(this);
        south.add(addToCart);

        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(scroll, BorderLayout.CENTER);
        contentPane.add(south, BorderLayout.SOUTH); 
        
        JLabel lblNewLabel = new JLabel(cartFacade.getTotalPrice() + " €");
        south.add(lblNewLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null,
                "Do you want to purchase the products in your cart ?",
                "Select an option",
                JOptionPane.OK_CANCEL_OPTION);
        while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION && input != JOptionPane.CLOSED_OPTION) {} 
        if(input == 0) { 
            var t = new PaymentView();
            t.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
    	UserFacade userFacade = new UserFacade(null);
		User user = userFacade.getUserDao().getUserById(1); 
		CartFacade cart = CartFacade.getCartFacade();
		//System.out.println(prod1);
		//cart.addProduct(prod1);
		System.out.println(cart.getNbItems());
		//new CartView(user);
	}

}
