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
    
      
    
    /** Private constructor (Singleton)
     * @return String
     */
    private String ProductFacade() {
        //TODO
       return null;
    }

  
    
    /** Get the instance of OrderFacade (Singleton)
     * @return OrderFacade
     */
    private OrderFacade getInstance() {
        return this.instance;
    }
    
  
    
    /** Set the instance of OrderFacade
     * @param instance
     */
    private void setInstance(OrderFacade instance) {
        this.instance = instance;
    }
    
    
  
    
    /** get the OrderView view
     * @return OrderView
     */
    public OrdersPayment getOrderView() {
        return this.orderView;
    }
    

  
    
    /** Get the orders associated to the facade
     * @return Order
     */
    public ArrayList<Order> getOrders() {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        OrderDao orderDao = abstractFactoryDao.createOrderDao(); 
        return orderDao.getOrdersPurchase(1); // METTRE LE VRAI ID !!!!!
    }
    
  
    
    /** 
     * @param order
     */
    public void set(Order[] orders ) {
        this.orders = orders ;
    }
    
  
    
    /** Get the AbstractFactoryDao
     * @return AbstractFactoryDao
     */
    public AbstractFactoryDao get() {
        return this.abstractFactoryDao;
    }
    


    /** Create an order in the database
     * @param order the order to create 
     * @return String the id of the order created in the database
     */
    public String createOrder(Order order) {
        return null;
    }
  
    
    /** Delete an order in the database using his id 
     * @param id id of the order to delete 
     */
    public void deleteOrderById(String id) {
        //TODO
    }
  
    
    /** Update an order in the database 
     * @param id id of the order to update 
     * @param newOrder the updated order
     */
    public void updateOrder(String id, Order newOrder) {
        //TODO
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