package UI.payment;

import java.awt.*; 
import javax.swing.*;    
import javax.swing.JLabel;   
import UI.ProductView; 

public class ProductsPayment extends JPanel {

    public JPanel labelContainer = new JPanel();  

    public ProductsPayment() {

        // top text 
        labelContainer.setLayout(new BoxLayout(labelContainer, BoxLayout.Y_AXIS));

        JLabel topLabel = new JLabel("Voici la liste des produits", SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        topLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelContainer.add(topLabel);  
  
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,50,100,50));
        this.add(labelContainer, BorderLayout.NORTH);
        this.add((new ProductView()).createListView(), BorderLayout.CENTER); 
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