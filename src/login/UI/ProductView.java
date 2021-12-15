package UI;
import javax.swing.JFrame;

import Core.ProductFacade;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductView implements ActionListener {
    
    
    private JFrame createProductView;
    
  
    private JFrame updateProductView;
    
   
    private JFrame deleteProductView;
    
   
    private JFrame detailledProductView;
    
   
    private JFrame ProductView;
    
    
   
    private ProductFacade productFacade ;
    
    
    
    
    /**  Get the product View
     * @return JFrame
     */
    public JFrame getCreateProductView() {
        return this.createProductView;
    }
    
  
    
    /** Get the Update Product View
     * @return JFrame
     */
    public JFrame getUpdateProductView() {
        return this.updateProductView;
    }
    
    
    
    
   
    
    /** Get the Delete Product View
     * @return JFrame
     */
    public JFrame getDeleteProductView() {
        return this.deleteProductView;
    }
    
   
    
    /** Get the Detailled Product View
     * @return JFrame
     */
    public JFrame getDetailledProductView() {
        return this.detailledProductView;
    }
    
  
  
    
    /** Get the Products View (List of all products)
     * @return JFrame
     */
    public JFrame getProductView() {
        return this.ProductView;
    }
    

    
    /** Get the Product facade
     * @return ProductFacade
     */
    public ProductFacade get() {
        return this.productFacade;
    }
    
    
    
    /** Set the product facade
     * @param productFacade
     */
    public void set(ProductFacade productFacade ) {
        this.productFacade = productFacade;
    }
    


    
    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
