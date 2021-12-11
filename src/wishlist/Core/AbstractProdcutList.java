package Core;
 
public abstract class AbstractProdcutList {
 
    private ArrayList<Product> products; 
    private String title; 
    private String body; 
    private TicketCategory category; 
    private String userEmail;
     
    /**
     * Constructor of AbstractProdcutList
     * @param id
     * @param products
     * @param title
     * @param body
     * @param category
     * @param userEmail
     */
    public AbstractProdcutList(int id, ArrayList<Product> products, String title, String body, TicketCategory category, String userEmail) {
        this.id = id;
        this.products = products; 
        this.title = title; 
        this.body = body; 
        this.category = category; 
        this.userEmail = userEmail;
    }

    /**
     * Getter of products
     * @return
     */
    public ArrayList<Product> getProducts() {
        return this.products;
    }
     
    /**
     * Setter of products
     * @param products
     */
    public void setProducts(Integer products) {
        this.products = products;
    }
 
    /**
     * Getter of title
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter of title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
  
    /**
     * Getter of body
     * @return
     */
    public String getBody() {
        return this.body;
    }
 
    /**
     * Setter of body
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Getter of category
     * @return
     */
    public TicketCategory getCategory() {
        return this.category;
    }
 
    /**
     * Setter of category
     * @param category
     */
    public void setCategory(TicketCategory category) {
        this.category = category;
    }
  
    /**
     * Getter of userEmail
     * @return
     */
    public String getUserEmail() {
        return this.userEmail;
    }
  
    /**
     * Setter of userEmail
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
 
    /**
     * Add a product to products
     */
    public void addProduct() {
        //TODO
    }
}
