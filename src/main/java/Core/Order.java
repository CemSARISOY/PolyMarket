package Core;

public class Order {
    
    /** id of the order
    */
    private int id; 

    /** user id */
    private int userId;
    
     /** Indicate if the order has been paid */
    private boolean isPaid;

    /** seller id */
    private int sellerId;
     
     /**The order facade associated to the order
    */
    private OrderFacade orderFacade;
    
    public Order(int id, int userId,boolean isPaid, int sellerId) { 
        this.id = id;
        this.userId = userId;
        this.isPaid = isPaid;
        this.sellerId = sellerId;
    }
  
    
    /** Get the id of the order
     * @return String
     */
    public int getId() {
        return this.id;
    } 
    
    /** Get the id of the user
     * @return userId
     */
    public int getUserId() {
        return this.userId;
    } 
    
    /** Get the id of the seller
     * @return sellerId
     */
    public int getSellerId() {
        return this.sellerId;
    } 
    
    /** Get a bool which represent if the order has been paid 
     * @return Boolean
     */
    public boolean getIsPaid() {
        return this.isPaid;
    }
     
    /** Set the isPaid attribute of the order
     * @param isPaid
     */
    public void setIsPayed(Boolean isPaid) {
        this.isPaid = isPaid;
    }
  
    /** Get the order facade
     * @return OrderFacade
     */
    public OrderFacade get() {
        return this.orderFacade;
    } 
   
    /** Set the order facade 
     * @param orderFacade
     */
    public void set(OrderFacade orderFacade ) {
        this.orderFacade = orderFacade ;
    }

    /** Pay the order     
    */
    public void pay() {
        //TODO
    }

}

