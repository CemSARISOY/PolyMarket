package Core; 

public class Orders_Products {
    
    /** id of the order
    */
    private int id; 

    /** user id */
    private int orderId;
    
    /** product id */
    private int productId;  
     
     /**The order facade associated to the order
    */
    private OrderFacade orderFacade;
    
    public Orders_Products(int id, int orderId,int productId) { 
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;  
    }
  
    
    /** Get the id of the Orders_Products
     * @return String
     */
    public int getId() {
        return this.id;
    } 
    
    /** Get the idOrder of the Orders_Products
     * @return int
     */
    public int getOrderId() {
        return this.orderId;
    }   
       
    /** Get the productId of the Orders_Products
     * @return int
     */
    public int getProductId() {
        return this.productId;
    }   
}

