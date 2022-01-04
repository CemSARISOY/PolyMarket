package UI;

import Core.Product;
import Core.User;
import Core.Wishlist;
import Core.WishlistFacade;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WishlistView extends JFrame implements ActionListener {

    //Core variables
    private WishlistFacade wishlistFacade  = WishlistFacade.getWishlistFacade();
    private ArrayList<Product> products;
    private User user;
    private Wishlist wishlist;

    //View variables
    private Container contentPane = getContentPane();

    public WishlistView(String id, User u){

        //GLOBAL VARIABLES INIT
        try {
            this.products = wishlistFacade.getProductsFromWishlistId(Integer.parseInt(id));
            this.wishlist = wishlistFacade.getWishlistById(Integer.parseInt(id));
            this.user = u;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //FRAME INIT
        this.setTitle("Your Wishlist");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //NORTH CONTENT
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(SwingConstants.NORTH_WEST));
        ImageIcon back = new ImageIcon(getClass().getResource("back.png"));
        Image newBack = back.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
        ImageIcon finalBack = new ImageIcon(newBack);
        JButton backBtn = new JButton(finalBack);
        backBtn.setBackground(Color.WHITE);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListWishlistsView listWishlistsView = new ListWishlistsView(user);
            }
        });
        north.add(backBtn);
        JLabel title = new JLabel(this.wishlist.getTitle()+"'s Wishlist");
        title.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
        north.add(title);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

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
                        try {
                            wishlistFacade.deleteProductFromWishlistById(wishlist.getId(),Integer.parseInt(but.getName()));
                            dispose();
                            WishlistView wishlistView = new WishlistView(id,user);
                        }
                        catch (Exception e2) {
                            JOptionPane.showMessageDialog(null, e2.getMessage());
                        }
                    }
                }
            });
            //ADD TO CART BUTTON
            ImageIcon img2 = new ImageIcon(getClass().getResource("panier.png"));
            Image newimg2 = img2.getImage().getScaledInstance(15,15, Image.SCALE_SMOOTH);
            ImageIcon finalImg2 = new ImageIcon(newimg2);
            JButton addBtn = new JButton(finalImg2);
            addBtn.setName(String.valueOf(products.get(i).getId()));
            addBtn.setBackground(Color.WHITE);
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton but = (JButton) e.getSource();
                    try {
                        wishlistFacade.addToCart(user.getId(),Integer.parseInt(but.getName()));
                        JOptionPane.showMessageDialog(null,
                                "Product added to cart !");
                    }
                    catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            });

            //Adding to right panel
            JPanel addPanel = new JPanel();
            addPanel.add(addBtn);
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
        JButton addToCart = new JButton("ADD ALL TO CART");
        addToCart.setForeground(Color.white);
        addToCart.setBackground(Color.black);
        addToCart.addActionListener(this);
        south.add(addToCart);

        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(scroll, BorderLayout.CENTER);
        contentPane.add(south, BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int input = JOptionPane.showConfirmDialog(null,
                "Do you really want to add all your products to your cart ?",
                "Select an option",
                JOptionPane.OK_CANCEL_OPTION);
        while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION) {}
        if(input == 0) {
            for(int i=0; i< products.size(); i++) {
                try {
                    wishlistFacade.addToCart(user.getId(), products.get(i).getId());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
            JOptionPane.showMessageDialog(null,
                    "All your products have been added to cart !");
        }
    }

}
