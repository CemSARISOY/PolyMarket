package Core;
 
public class Delivery {
     
    private int id; 
    private bool isDelivered;  
    
    /**
     * Constructor of Delivery
     * @param id
     * @param isDelivered
     */
    public Delivery(int id, bool isDelivered) {
        this.id = id;
        this.isDelivered = isDelivered;
    }

    /**
     * Getter of id
     * @return
     */
    public int getId() {
        return this.id;
    } 
     
    /**
     * Getter of isDelivered
     * @return
     */
    public bool getIsDelivered() {
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
