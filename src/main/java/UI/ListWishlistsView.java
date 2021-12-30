package UI;

import Core.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListWishlistsView extends JFrame implements ActionListener {

    //Core variables
    private WishlistFacade wishlistFacade  = WishlistFacade.getWishlistFacade();
    private LoginFacade loginFacade  = new LoginFacade();
    private ArrayList<Wishlist> wishlists;
    private User user;

    //View variables
    private Container contentPane = getContentPane();

    public ListWishlistsView(User u){

        //GLOBAL VARIABLES INIT
        try {
            this.user = u;
            this.wishlists = wishlistFacade.getWishlistsFromUser(u.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //FRAME INIT
        this.setTitle("List of your wishlist");
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
            }
        });
        north.add(backBtn);
        JLabel title = new JLabel("List of your wishlists");
        title.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
        north.add(title);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        //CENTER CONTENT
        //Center config
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,200,200,200));
        center.setLayout(new GridLayout(0,1));

        //Wishlists management
        for(var i =0; i< wishlists.size(); i++) {

            //Main Button
            JPanel wishPanel =new JPanel();
            JButton wishButton = new JButton(wishlists.get(i).getTitle());
            wishButton.setName(String.valueOf(wishlists.get(i).getId()));
            wishButton.setPreferredSize(new Dimension(500,75));
            wishButton.setBackground(Color.darkGray);
            wishButton.setForeground(Color.white);

            //Ticket Button action performed
            wishButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e1) {
                    JButton b = (JButton) e1.getSource();
                    dispose();
                    WishlistView wishlistView = new WishlistView(b.getName());
                }
            });

            JPanel btnPanel = new JPanel();
            btnPanel.add(wishButton);
            btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

            //Left Label infos
            JLabel wishId = new JLabel("<html> Wishlist id : "+String.valueOf(wishlists.get(i).getId())+"<br>");
            wishId.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

            //Delete Button
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
            ImageIcon img = new ImageIcon(getClass().getResource("poubelle.png"));
            Image newimg = img.getImage().getScaledInstance(15,15, Image.SCALE_SMOOTH);
            ImageIcon finalImg = new ImageIcon(newimg);
            JButton delBtn = new JButton(finalImg);
            delBtn.setName(String.valueOf(wishlists.get(i).getId()));
            delBtn.setBackground(Color.WHITE);
            delBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton but = (JButton) e.getSource();
                    int input = JOptionPane.showConfirmDialog(null,
                            "Do you really want to delete this Wishlist ?",
                            "Select an option",
                            JOptionPane.OK_CANCEL_OPTION);
                    while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION) {}
                    if(input == 0) {
                        try {
                            wishlistFacade.deleteWishlistById(Integer.parseInt(but.getName()));
                            dispose();
                            ListWishlistsView listWishlistsView = new ListWishlistsView(user);
                        }
                        catch (Exception e2) {
                            JOptionPane.showMessageDialog(null, e2.getMessage());
                        }
                    }
                }
            });
            rightPanel.add(delBtn);


            //Grouping
            wishPanel.add(wishId);
            wishPanel.add(btnPanel);
            wishPanel.add(rightPanel);
            wishPanel.setBorder(new LineBorder(Color.black, 1, true));
            center.add(wishPanel);
        }

        //Center Scrollable
        JScrollPane scroll = new JScrollPane(center,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //SOUTH
        JPanel south = new JPanel();
        south.setBorder(BorderFactory.createEmptyBorder(40,0,40,0));
        JButton create = new JButton("Create a new Wishlist");
        create.setForeground(Color.white);
        create.setBackground(Color.black);
        create.addActionListener(this);
        south.add(create);

        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(scroll, BorderLayout.CENTER);
        contentPane.add(south, BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        NewWishlistView newWishlistView = new NewWishlistView(user);
    }

    public static void main(String[] args) {
        ListWishlistsView listWishlistsView = new ListWishlistsView(new User(1));
    }
}
