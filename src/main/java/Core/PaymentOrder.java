package Core;


public class PaymentOrder {
    
    private Integer id;
    private Boolean isPayed;
    private Integer BuyerID;
    private Integer SellerID;
    private Integer ProductID;

    /**
    Getters and setters
    */
    public Integer getId() {
        return this.id;
    }

    public Integer setId(Integer id) {
        this.id = id;
        return this.id;
    }
    
    public Boolean getIsPayed() {
        return this.isPayed;
    }
 
    public Boolean setIsPayed(Boolean isPayed) {
        this.isPayed = isPayed;
        return this.isPayed;
    }
    
    public Integer getBuyerID() {
        return this.BuyerID;
    }
    
    public Integer setBuyerID(Integer BuyerID) {
        this.BuyerID = BuyerID;
        return this.BuyerID;
    }
    
    public Integer getSellerID() {
        return this.SellerID;
    }
    
    public Integer setSellerID(Integer SellerID) {
        this.SellerID = SellerID;
        return this.SellerID;
    }
    
    public Integer getProductID() {
        return this.ProductID;
    }
    
    public Integer setProductID(Integer ProductID) {
        this.ProductID = ProductID;
        return this.ProductID;
    }
    
}
