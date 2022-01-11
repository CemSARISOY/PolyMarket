package Core;
 
public class Delivery {
     
    private int id;
    private boolean isDelivered;
    private int sellerId;
    private int buyerId;
    private int productId;
    
    /**
     * Constructor of Delivery when id is know (received from DB)
     * @param id
     * @param isDelivered
     */
    public Delivery(int id, int s, int b, int p, boolean isDelivered) {
        this.id = id;
        this.isDelivered = isDelivered;
        this.sellerId = s;
        this.buyerId = b;
        this.productId = p;
    }

    public Delivery(int s, int b, int p, boolean isDelivered) {
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


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Delivery))
            return false;
        Delivery d2 = (Delivery) obj;
        if (this.id != d2.id || this.isDelivered != d2.isDelivered || this.sellerId != d2.sellerId
                || this.buyerId != d2.buyerId || this.productId != d2.productId)
            return false;
        return true;
    }

}
