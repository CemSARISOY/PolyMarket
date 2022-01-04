package UI.payment;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter;

public class SpecificOrderPayment extends JPanel {

    public SpecificOrderPayment() { 
        // top text
        JPanel labelContainer = new JPanel();
        JLabel topLabel = new JLabel("Voici la liste de vos commandes", SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        labelContainer.add(topLabel);
 
        // list of orders 
        JPanel liste = new JPanel(); //Panel où on place tous les événements
        JScrollPane scroll = new JScrollPane(liste, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        scroll.setBounds(0, 0, 900, UNDEFINED_CONDITION);
        liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 2; i++) {   
            JPanel cell = new JPanel();  
            cell.setBorder(new LineBorder(Color.BLACK)); 
            cell.setLayout(new BorderLayout());
            cell.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

            // left side
            JPanel cellLeft = new JPanel(); 
            cellLeft.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
            cellLeft.setLayout(new BoxLayout(cellLeft, BoxLayout.Y_AXIS));
            
            JPanel product = new JPanel(); 
            product.setLayout(new GridLayout(1, 2));
            product.setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(4,4,4,4),
                new LineBorder(Color.BLACK)
            ));

            try { 
                ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("nft2.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                JLabel productImage = new JLabel(image);  
                product.add(productImage); 
            } catch (Exception e) {
                e.printStackTrace();
                product.add(new JLabel("Image not found")); 
            }

            // JLabel productName = new JLabel("Produit : " + i);
            // productName.setFont(new Font("Serif", Font.PLAIN, 16));  
            // product.add(productName); 
            
            cellLeft.add(product); 

            // center side             
            JPanel cellCenter = new JPanel(); 
            cellCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            cellCenter.setLayout(new BorderLayout());
            
            JLabel productName = new JLabel("Nom du produit : " + i + " (#00" + i + ")");
            productName.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(productName, BorderLayout.NORTH);
                        
            JLabel description = new JLabel("Description : " + i);
            description.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(description, BorderLayout.CENTER);
            
            JLabel price = new JLabel("Prix : " + i);
            price.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(price, BorderLayout.SOUTH);

            // right side
            JPanel cellRight = new JPanel();
            cellRight.setLayout(new BorderLayout());
            cellRight.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
             
            ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("oeil.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JLabel eyeImage = new JLabel(image, SwingConstants.RIGHT);    
            eyeImage.addMouseListener(new MouseInputAdapter() { 
                @Override
                public void mouseClicked(MouseEvent e) { 
                    super.mouseClicked(e);
                    // GO TO PRODUCT PAGE
                }
            });  
            cellRight.add(eyeImage, BorderLayout.NORTH);

            JPanel status = new JPanel();
            JLabel statusLabel = new JLabel("Statut : ");
            statusLabel.setFont(new Font("Serif", Font.PLAIN, 16));
            JPanel statusColor = new JPanel();
            statusColor.setBorder(new RoundedBorder(3));
            statusColor.setSize(2, 2);
            statusColor.setForeground(Color.red); 
            status.add(statusLabel);
            status.add(statusColor);
            cellRight.add(status, BorderLayout.SOUTH);

            // cell
            cell.add(cellLeft, BorderLayout.WEST); 
            cell.add(cellCenter, BorderLayout.CENTER); 
            cell.add(cellRight, BorderLayout.EAST); 
 
            liste.add(cell); 
            liste.add(Box.createRigidArea(new Dimension(0, 15)));
        }  

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,50,100,50));
        this.add(labelContainer, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER); 
        this.setVisible(true);
    }
}


