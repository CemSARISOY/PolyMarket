package UI;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Core.Product;
import Core.ProductFacade;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductView extends JFrame implements ActionListener {
    
    
    private JFrame createProductView;
    
  
    private JFrame updateProductView;
    
   
    private JFrame deleteProductView;
    
   
    private JFrame detailledProductView;
    
   
    private JFrame productList;
    
    
   
    private ProductFacade productFacade = ProductFacade.getInstance();
    
    public ProductView(){
        JButton button1 = new JButton("Liste des produits");
        JButton button2 = new JButton("Ajouter un produit");
        button1.addActionListener(this);
        button2.addActionListener(this);
        Container c =  this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(button1);
        c.add(button2);
        this.pack();
        setVisible(true);
    }

    private void createListView(){
        List<Product> products = productFacade.getProducts();

        this.productList = new JFrame();
        Container c = productList.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new JButton("test"), BorderLayout.NORTH);

        Container center = new Container();
        center.setLayout(new FlowLayout());
        for(Product p : products){
            center.add(new JLabel(p.getName()));
        }

        
        productList.pack();
        productList.setVisible(true);
    }



    
    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Liste des produits":
                createListView();
                break;
            case "Ajouter un produit":
                createProductView.setVisible(true);
                break;
        }
        
    }

    public static void main(String[] args) {
        new ProductView();
    }
}
