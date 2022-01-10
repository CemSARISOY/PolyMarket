package UI.payment;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter; 
import Core.Order;
import Core.Orders_Products;
import Core.Product;
import Persist.AbstractFactoryDao;
import UI.ProductView;

public class SpecificOrderPayment extends JPanel {

    public SpecificOrderPayment(Order order) { 
        // top text
        JPanel labelContainer = new JPanel();
        JLabel topLabel = new JLabel("Voici la liste des produits  de la commande n°" + order.getId(), SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        labelContainer.add(topLabel);
 
        // list of orders 
        JPanel liste = new JPanel(); //Panel où on place tous les événements
        JScrollPane scroll = new JScrollPane(liste, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        scroll.setBounds(0, 0, 900, UNDEFINED_CONDITION);
        liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
        var af = AbstractFactoryDao.getFactory("mysql");
        var pdao = af.createProductDao();
        var op = af.createOrders_ProductsDAO().getOrders_ProductsByOrderId(order.getId());
        ArrayList<Product> products = new ArrayList<>();
        for (var p : op) {
            products.add(pdao.getProductById(p.getProductId()));
        }
        for (var p : products) {   
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
            cellLeft.add(product); 

            // center side             
            JPanel cellCenter = new JPanel(); 
            cellCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            cellCenter.setLayout(new BorderLayout());
            
            JLabel productName = new JLabel("Nom du produit : " + p.getName() + " (#" + p.getId() + ")");
            productName.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(productName, BorderLayout.NORTH);
                        
            JLabel description = new JLabel("Description : " + p.getBody());
            description.setFont(new Font("Serif", Font.PLAIN, 16)); 
            cellCenter.add(description, BorderLayout.CENTER);
            
            JLabel price = new JLabel("Prix : " + p.getPrice());
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
                    new ProductView().viewDetails(p.getId());
                }
            });  
            cellRight.add(eyeImage, BorderLayout.NORTH);
 
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


