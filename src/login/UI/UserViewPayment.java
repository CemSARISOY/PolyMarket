package UI;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.Border;

import Core.PaymentFacade;

/**
* @generated
*/
public class UserViewPayment extends JFrame implements ActionListener {                                
    
    private PaymentFacade paymentFacade = new PaymentFacade();
    private Container contentPane = this.getContentPane();
    public UserViewPayment() {

        // top buttons
        JButton[] buttons = {
            new JButton("Produits"),
            new JButton("Commandes"),
            new JButton("Catégories")
        };

        for (var button : buttons) {
            button.setMargin(new Insets(10,20,10,20));
        }

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JPanel topButtons = new JPanel();
        topButtons.setLayout(new FlowLayout(FlowLayout.CENTER , 50, 20));
        topButtons.add(buttons[0]);
        topButtons.add(buttons[1]);
        topButtons.add(buttons[2]);

        // top text
        JPanel labelContainer = new JPanel();
        JLabel topLabel = new JLabel("Voici la liste des produits", SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        labelContainer.add(topLabel);
 
        // list of products 
        JPanel liste = new JPanel(); //Panel où on place tous les événements
        JScrollPane scroll = new JScrollPane(liste, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 0, 930, 610);
        liste.setLayout(new GridLayout(50, 1));
        for (int i = 1; i <= 50; i++) {
            // cell
            liste.add(new JButton("product n°" + i)); // add cell
        }  
        JScrollPane scrollList = new JScrollPane(liste);  
        scrollList.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));

        header.add(topButtons);
        header.add(labelContainer);

        contentPane.add(header,  BorderLayout.NORTH);
        contentPane.add(scrollList,  BorderLayout.CENTER);
        this.setVisible(true);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    } 

    public void pay() {
        paymentFacade.pay();
    }

    public static void main(String[] args) {
        new UserViewPayment();
    }
}

