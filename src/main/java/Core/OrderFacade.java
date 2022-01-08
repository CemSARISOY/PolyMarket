package Core;

import java.util.ArrayList;
import java.util.Observable;

import Persist.AbstractFactoryDao;
import Persist.OrderDao;
import UI.payment.OrdersPayment;

/** Class OrderFacade
* @generated
*/
public class OrderFacade extends Observable {
    
  
    private OrderFacade instance;
     
    private OrdersPayment orderView ;
     
    private Order[] orders;
    
    private AbstractFactoryDao abstractFactoryDao;
      
    /** Get the instance of OrderFacade (Singleton)
     * @return OrderFacade
     */
    private OrderFacade getInstance() {
        return this.instance;
    }
    
    /** Get the orders associated to the facade
     * @return Order
     */
    public ArrayList<Order> getOrders() {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        OrderDao orderDao = abstractFactoryDao.createOrderDao(); 
        return orderDao.getOrdersPurchase(LoginFacade.getLoginFacade().getUser().getId());
    } 


    /** Create an order in the database
     * @param order the order to create 
     * @return String the id of the order created in the database
     */
    public String createOrder(Order order) {
        return null;
    }  
    
    /** Get the orders sold by the user 
     * @param user
     * @return Order[]
     */
    public Order[] getOrdersSold(User user) {
        return null;
    }
  
    
    /** Get the orders purchased by the user 
     * @param user
     * @return Order[]
     */
    public Order[] getOrdersPurchased(User user) {
        return null;
    }
    
}
