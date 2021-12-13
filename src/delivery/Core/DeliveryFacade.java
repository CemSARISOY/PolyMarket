package Core;
 
public class DeliveryFacade {  

    private AbstractFactoryDao abstractFactoryDao;
    
    private User user;  
    private User seller;
    private Product product;

    /**
     * Constructor of DeliveryFacade
     */
    public DeliveryFacade() { }
     
    /**
     * Getter of user
     * @return DeliveryFacade's user
    */
    public User getUser() {
        return this.user;
    } 

    /**
     * Getter of seller
     * @return DeliveryFacade's seller
    */
    public User getSeller() {
        return this.seller;
    }

    /**
     * Getter of product
     * @return DeliveryFacade's product
    */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Deliver the product from the buyer (me) to the seller 
     * @param buyer
     * @param seller
     * @param product
     */
    public void deliver(User buyer, User seller, Product product) {
        //TODO
    } 
}
