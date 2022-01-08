package UI.payment;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Core.LoginFacade;
import Core.PaymentFacade;
import UI.AdminViewAbuse;
import UI.AuctionView;
import UI.CartView;
import UI.ProductView;
import UI.UserProfileView;
import UI.category.UserViewCategory;

/**
* @generated
*/
public class UserViewPayment extends JFrame {                                
    
    private PaymentFacade paymentFacade = new PaymentFacade();
    private Container contentPane = this.getContentPane();
    private LoginFacade loginFacade = LoginFacade.getLoginFacade();

    // top buttons
    public JButton[] buttons = {
        new JButton("Profil"),
        new JButton("Produits"),
        new JButton("Auctions"),
        new JButton("Commandes"),
        new JButton("Catégories"),
        new JButton("Abus"),
        new JButton("Panier")
    };
    
    // boolean isAdmin = loginFacade.getUser().getIsAdmin();
    boolean isAdmin = false;

    public JPanel content = new JPanel(); 
    public UserProfileView profil = new UserProfileView(loginFacade.getUser(), loginFacade.getUser());
    public Container products = (new ProductView()).createListView();
    public Container auctions = (new AuctionView()).createListView();
    public OrdersPayment orders = new OrdersPayment();
    public UserViewCategory categories = new UserViewCategory();
    public Container abuses = (new AdminViewAbuse()).getList();
    public Container cart = (new CartView(loginFacade.getUser())).contentPane;

    public UserViewPayment() {  
        for (var button : buttons) {
            button.setMargin(new Insets(10,20,10,20));
            button.setBackground(Color.WHITE);
            button.setPreferredSize(new Dimension(200, 40));
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    initTab(button.getText(), null);
                }
            });
        }

        JPanel header = new JPanel();

        JPanel topButtons = new JPanel();
        topButtons.setLayout(new FlowLayout(FlowLayout.CENTER , 50, 20)); 
        topButtons.add(buttons[0]);
        topButtons.add(buttons[1]);
        topButtons.add(buttons[2]);
        topButtons.add(buttons[3]);
        topButtons.add(buttons[4]);
        if (isAdmin) topButtons.add(buttons[5]);
        topButtons.add(buttons[6]);
  
        header.add(topButtons);

        initTab(buttons[0].getText(), null);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(profil);
        content.add(products);
        content.add(auctions);
        content.add(orders);
        content.add(categories);
        if (isAdmin) content.add(abuses);
        content.add(cart);


        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(content, BorderLayout.CENTER);

        this.setVisible(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void initTab(String tab, ArrayList<JButton> selectedCategories) {
        products.setVisible(false);
        orders.setVisible(false);
        categories.setVisible(false);
        auctions.setVisible(false);
        profil.setVisible(false);
        abuses.setVisible(false);
        cart.setVisible(false);
        buttons[0].setBackground(Color.WHITE);
        buttons[1].setBackground(Color.WHITE);
        buttons[2].setBackground(Color.WHITE);
        buttons[3].setBackground(Color.WHITE);
        buttons[4].setBackground(Color.WHITE);
        if (isAdmin) buttons[5].setBackground(Color.WHITE);
        buttons[6].setBackground(Color.WHITE);

        if (tab == buttons[3].getText()) {
            buttons[3].setBackground(Color.decode("#DCDCDC"));
            orders.setVisible(true); 
            if (selectedCategories != null) {
                for (var sc : selectedCategories) {
                    // get by category => sc.getText(); 
                }
            }
        }
        else if (tab == buttons[4].getText()) {
            buttons[4].setBackground(Color.decode("#DCDCDC"));
            categories.setVisible(true);
        }
        else if (tab == buttons[2].getText()) {
            buttons[2].setBackground(Color.decode("#DCDCDC"));
            auctions.setVisible(true);
        }
        else if (tab == buttons[1].getText()) {
            buttons[1].setBackground(Color.decode("#DCDCDC"));
            products.setVisible(true);
        }
        else if (isAdmin && tab == buttons[5].getText()) {
            buttons[5].setBackground(Color.decode("#DCDCDC"));
            abuses.setVisible(true);
        }
        else if (tab == buttons[6].getText()) {
            buttons[6].setBackground(Color.decode("#DCDCDC"));
            cart.setVisible(true);
        }
        else {
            buttons[0].setBackground(Color.decode("#DCDCDC"));
            profil.setVisible(true);
        } 
    }

    public void pay() {
        paymentFacade.pay();
    } 
}

