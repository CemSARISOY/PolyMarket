package UI;

import javax.swing.JFrame;

import Core.OrderFacade;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView implements ActionListener {
    
    
    private JFrame toConfirmOrderView;
  
    private JFrame listOfOrderView;
    
   
    private JFrame deleteOrderView;
    
    
    
    private OrderFacade orderFacade ;
    
    
  
    
    /** Get the to confirm view of order
     * @return JFrame
     */
    public JFrame getToConfirmOrderView() {
        return this.toConfirmOrderView;
    }
    
  

  
    
    /** Get the order list view
     * @return JFrame
     */
    public JFrame getListOfOrderView() {
        return this.listOfOrderView;
    }
    
    
    

   
    
    /** Get the delete view
     * @return JFrame
     */
    public JFrame getDeleteOrderView() {
        return this.deleteOrderView;
    }
    
    
    
   
    
    /** Get the order facade
     * @return OrderFacade
     */
    public OrderFacade get() {
        return this.orderFacade;
    }
    
   
    
    /** Set the order list view
     * @param orderFacade
     */
    public void set(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }
    


    
    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
