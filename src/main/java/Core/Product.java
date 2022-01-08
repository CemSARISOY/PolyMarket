package Core;

import java.io.File;
import java.util.Date;

/**
 * Class Product
 */
public class Product {
    

    private int id;
    private String name;
    private String token;
    private String content;
    private ProductCategory category;
    private String body;
    private User author;
    private double price;
    private Date startDate;
    private boolean sold;


    public Product(int id, String name, String token, String content, ProductCategory category, String body, User author, double price, Date startDate, boolean sold) {
        this.id = id;
        this.name = name;
        this.token = token;
        this.content = content;
        this.category = category;
        this.body = body;
        this.author = author;
        this.price = price;
        this.startDate = startDate;
        this.sold = sold;
    }

    
    /** Get the id of the product
     * @return id
     */
    public int getId() {
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
    public String getContent() {
        return this.content;
    }
    

    
    /** Set the content of the product
     * @param content
     */
    public void setContent(String content) {
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
    public double getPrice() {
        return this.price;
    }
    

    
    /** Set the price of the product
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    

    
    /** Get the startDate of the product
     * @return Date
     */
    public Date getStartDate() {
        return this.startDate;
    }
    
    public int getAuthor() {
        return this.author;
    }
    

    
    /** Set the startDate of the product
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
