package Core;

import java.io.File;
import java.util.Date;

/**
 * Class Product
 */
public class Product {
    

    private Integer id;
    

    private String name;
    

    private String token;
    

    private File content;
    

    private ProductCategory category;
    

    private String body;
    

    private User author;
    

    private float price;
    

    private Date startDate;
    
    

    private AuctionFacade auctionFacade;
    
    

    
    /** Get the id of the product
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }


    
    /** Get the name of the product
     * @return String
     */
    public String getName() {
        return this.name;
    }
    

    
    /** Set the name of the product
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    

    
    /** Get the token of the product
     * @return String
     */
    public String getToken() {
        return this.token;
    }
    

    
    /**  Set the token of the product
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }
    

    
    /** Get the content of the product 
     * @return File
     */
    public File getContent() {
        return this.content;
    }
    

    
    /** Set the content of the product
     * @param content
     */
    public void setContent(File content) {
        this.content = content;
    }
    

    
    /** get the category of the product
     * @return ProductCategory
     */
    public ProductCategory getCategory() {
        return this.category;
    }
    

    
    /** Set the category of the product
     * @param category
     */
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    

    
    /** Get the body of the product
     * @return String
     */
    public String getBody() {
        return this.body;
    }
    

    
    /** Set the body of the product
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }
    

    
    /** Get the author of the product
     * @return User
     */
    public User getAuthor() {
        return this.author;
    }
    

    
    /** Set the author of the product
     * @param author
     */
    public void setAuthor(User author) {
        this.author = author;
    }
    

    
    /** Get the price of the product 
     * @return float
     */
    public float getPrice() {
        return this.price;
    }
    

    
    /** Set the price of the product
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }
    

    
    /** Get the startDate of the product
     * @return Date
     */
    public Date getStartDate() {
        return this.startDate;
    }
    

    
    /** Set the startDate of the product
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
}
