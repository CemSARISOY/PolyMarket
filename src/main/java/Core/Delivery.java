package Core;
 
public class Delivery {
     
    private int id; 
    private boolean isDelivered;
    private int sellerId;
    private int buyerId;
    private int productId;
    
    /**
     * Constructor of Delivery
     * @param id
     * @param isDelivered
     */
    public Delivery(Integer id, int s, int b, int p, boolean isDelivered) {
        this.id = id;
        this.isDelivered = isDelivered;
        this.sellerId = s;
        this.buyerId = b;
        this.productId = p;
    }

    /**
     * Getter of id
     * @return Delivery's id
     */
    public int getId() {
        return this.id;
    }

    public int getSellerId(){
        return sellerId;
    }

    public int getBuyerId(){
        return buyerId;
    }

    public int getProductId() {
        return productId;
    }
     
    /**
     * Getter of isDelivered
     * @return Delivery's isDelivered
     */
    public boolean getIsDelivered() {
        return this.isDelivered;
    }
     
    /**
     * Setter of isDelivered
     * @param isDelivered
     */
    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    } 
}
