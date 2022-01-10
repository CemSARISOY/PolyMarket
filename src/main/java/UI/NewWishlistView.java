package UI;

import Core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewWishlistView extends JFrame implements ActionListener {

    //Core variables
    User user;
    private WishlistFacade wishlistFacade = WishlistFacade.getWishlistFacade();
    private ArrayList<Product> products = new ArrayList<>();

    //View variables
    private Container contentPane = getContentPane();
    JTextField titleArea;

    public NewWishlistView(User u){

        //GLOBAL VARIABLES INIT
        this.user = u;

        //INIT
        this.setTitle("Create a new Wishlist");
        setVisible(true);

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
        JLabel header = new JLabel("Create a new Wishlist");
        header.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
        north.add(header);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        //CENTER CONTENT
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,100,100,500));
        center.setLayout(new GridLayout(0, 1));

        JLabel title = new JLabel("Title");
        titleArea = new JTextField(30);
        JPanel titlePanel = new JPanel(new FlowLayout(SwingConstants.WEST));
        titlePanel.add(titleArea);
        center.add(title);
        center.add(titlePanel);

        JButton send = new JButton("Create");
        send.setForeground(Color.WHITE);
        send.setBackground(Color.BLACK);
        send.addActionListener(this);
        JPanel panelBtn = new JPanel();
        panelBtn.add(send);
        panelBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,200));
        center.add(panelBtn);


        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String title = titleArea.getText();
        if(title.length() > 30 || title.length() == 0){
            JOptionPane.showMessageDialog(null, "Your title is empty or too long (>30 chars)");
            return;
        }
        int input = JOptionPane.showConfirmDialog(null,
                "Do you really want to create this Wishlist ?",
                "Select an option",
                JOptionPane.OK_CANCEL_OPTION);
        while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION) {}
        if(input == 0){
            Wishlist wishlist = new Wishlist(user.getId(), title);
            try{
                wishlistFacade.createWishlist(wishlist);
            }
            catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
            int res = JOptionPane.showOptionDialog(null, "Wishlist successfully created", "Information", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            while(res != 0 && res != -1){}
            dispose();
            ListWishlistsView listWishlistsView = new ListWishlistsView(user);
        }
    }
}
