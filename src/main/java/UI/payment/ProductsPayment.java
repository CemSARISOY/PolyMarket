package UI.payment;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;  
import javax.swing.border.*; 

public class ProductsPayment extends JPanel {

    public JPanel labelContainer = new JPanel();

    public ProductsPayment() {

        // top text 
        labelContainer.setLayout(new BoxLayout(labelContainer, BoxLayout.Y_AXIS));

        JLabel topLabel = new JLabel("Voici la liste des produits", SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        topLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelContainer.add(topLabel); 
 
        // list of products 
        JPanel liste = new JPanel(); //Panel où on place tous les événements
        JScrollPane scroll = new JScrollPane(liste, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        scroll.setBounds(0, 0, 900, UNDEFINED_CONDITION);
        liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 2; i++) { 
            JPanel cell = new JPanel(); 
            cell.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
            cell.setBorder(new LineBorder(Color.BLACK));
            cell.setLayout(new GridLayout(1, 2));
            cell.add(new JLabel("Produit n°" + i), 0, 0);
            
            JButton buy = new JButton("Acheter"); 
            buy.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame test = new JFrame();
                    test.add(new PaymentView());
                    test.setVisible(true);
                    test.pack(); 
                }
            });
            cell.add(buy, 0, 1);

            liste.add(cell); 
            liste.add(Box.createRigidArea(new Dimension(0, 15)));
        }  

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,50,100,50));
        this.add(labelContainer, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER); 
        this.setVisible(true);
    }

    public void initFilters(String str) {
        JLabel filterLabel = new JLabel(str, SwingConstants.CENTER);
        filterLabel.setFont(new Font("Serif", Font.ITALIC, 16));
        filterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  

        try {
            labelContainer.remove(1);
        }
        catch (Exception e) { }
        finally { 
            labelContainer.add(filterLabel);
        }
    }
}
