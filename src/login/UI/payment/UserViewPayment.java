package UI.payment;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Core.PaymentFacade;
import UI.category.UserViewCategory;

/**
* @generated
*/
public class UserViewPayment extends JFrame {                                
    
    private PaymentFacade paymentFacade = new PaymentFacade();
    private Container contentPane = this.getContentPane();

    // top buttons
    public JButton[] buttons = {
        new JButton("Produits"),
        new JButton("Commandes"),
        new JButton("Catégories")
    };
    
    public JPanel content = new JPanel();
    public ProductsPayment products = new ProductsPayment();
    public OrdersPayment orders = new OrdersPayment();
    public UserViewCategory categories = new UserViewCategory();

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
  
        header.add(topButtons);

        initTab(buttons[0].getText(), null);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(products);
        content.add(orders);
        content.add(categories);

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
        buttons[0].setBackground(Color.WHITE);
        buttons[1].setBackground(Color.WHITE);
        buttons[2].setBackground(Color.WHITE);

        if (tab == buttons[1].getText()) {
            buttons[1].setBackground(Color.decode("#DCDCDC"));
            orders.setVisible(true); 
            if (selectedCategories != null) {
                for (var sc : selectedCategories) {
                    // get by category => sc.getText(); 
                }
            }
        }
        else if (tab == buttons[2].getText()) {
            buttons[2].setBackground(Color.decode("#DCDCDC"));
            categories.setVisible(true);
        }
        else {
            buttons[0].setBackground(Color.decode("#DCDCDC"));
            products.setVisible(true);
        }

    }

    public void pay() {
        paymentFacade.pay();
    }

    public static void main(String[] args) {
        new UserViewPayment();
    }
}

