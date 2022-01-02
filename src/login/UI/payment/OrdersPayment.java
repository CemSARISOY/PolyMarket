package UI.payment;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Persist.OrderDaoMySql;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter;

import Core.Order;
import Core.OrderFacade; 
public class OrdersPayment extends JPanel {

    private OrderFacade orderFacade = new OrderFacade();
    
    public OrdersPayment() { 
        // top text
        JPanel labelContainer = new JPanel();
        JLabel topLabel = new JLabel("Voici la liste de vos commandes", SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        labelContainer.add(topLabel);
 
        // list of orders 
        ArrayList<Order> orders = orderFacade.getOrders();
        JPanel liste = new JPanel(); 
        JScrollPane scroll = new JScrollPane(liste, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        scroll.setBounds(0, 0, 900, UNDEFINED_CONDITION);
        liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
        for (Order order : orders) { 
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
                ImageIcon image = new ImageIcon(new ImageIcon("src\\login\\UI\\payment\\nft2.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
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
            
            JLabel date = new JLabel("Date : " + order.getId());
            date.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(date, BorderLayout.NORTH);
                        
            JLabel nbProducts = new JLabel("Nombre de produits : " + order.getId());
            nbProducts.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(nbProducts, BorderLayout.CENTER);
            
            JLabel price = new JLabel("Prix total : " + order.getId());
            price.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(price, BorderLayout.SOUTH);

            // right side
            JPanel cellRight = new JPanel();
            cellRight.setLayout(new BorderLayout());
            cellRight.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
             
            ImageIcon image = new ImageIcon(new ImageIcon("src\\login\\UI\\payment\\oeil.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JLabel eyeImage = new JLabel(image, SwingConstants.RIGHT);   
            eyeImage.addMouseListener(new MouseInputAdapter() { 
                @Override
                public void mouseClicked(MouseEvent e) { 
                    super.mouseClicked(e);
                    var t = new JFrame();
                    t.add(new SpecificOrderPayment());
                    t.setVisible(true);
                    t.pack();
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

