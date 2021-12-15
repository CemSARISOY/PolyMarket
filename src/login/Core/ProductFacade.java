package Core;

import Persist.AbstractFactoryDao;
import UI.ProductView;

/** Class ProductFacade
* @generated
*/
public class ProductFacade {
    
    /**
     * Instance of the ProductFacade class (Singleton)
     */
    private ProductFacade instance;
    
    
    
    private Product[] products ;
    
 
    private AbstractFactoryDao abstractFactoryDao ;
    
 
    private ProductView productView;
    
    
 
    
    /** Get the singleton instance of the ProductFacade
     * @return ProductFacade
     */
    private ProductFacade getInstance() {
        return this.instance;
    }
    
 
    
    /** Get th product view
     * @return ProductView
     */
    public ProductView getProductView() {
        return this.productView;
    }

 
    
    /** 
     * @return Product[]
     */
    public Product[] getProducts() {
        return this.products;
    }
    
 
    
    /** Set the products of the ProductFacade class
     * @param products
     * @return Product
     */
    public Product set(Product[] products ) {
        return null;
    }
    
 
    
    /** Get the AbstractFactoryDao
     * @return AbstractFactoryDao
     */
    public AbstractFactoryDao get() {
        return this.abstractFactoryDao;
    }

    
    /**
     * Private constructor of the class (Singleton)
     */
    private ProductFacade() {
        //TODO
    }


    
    /** Create a new product in the database with a Product
     * @param product Product to be created 
     * @return String id of the product created in the database
     */
    public String createProduct(Product product) {
        return null;
    }
   
    
    /** Update a product in the database 
     * @param id id of the product to upadate 
     * @param newproduct product with the changes 
     */
    public void updateProduct(String id, Product newproduct) {
        
    }
   
    
    /** Get a product in the databse using an id 
     * @param id id of the product to get 
     * @return Product
     */
    public Product getProductById(String id) {
        return null;
    }
   
    /** Purchase a product directly 
     * @param product product to buy  
     */
    public void purchase(Product product) {
        //TODO
    }
   
    /** Add a product to the cart 
     * @param product product to add to the cart  
     */
    public void addToCart(Product product) {
        //TODO
    }
   
    
    /** Get the products in the database owned by an user
     * @param user 
     * @return Product[] List of the products of the user 
     */
    public Product[] getProductsByUser(User user) {
        return null;
    }
   
    
    /** Get the products in the database by their category 
     * @param category category of the product
     * @return Product[]
     */
    public Product[] getProductsByCategory(ProductCategory category) {
        return null;
    }
   
    
    /** Get the products of an Author in the database 
     * @param user The author 
     * @return Product[]
     */
    public Product[] getProductsByAuthor(User author) {
        return null;
    }
   

     /** Like a product
     * @param product the product to like 
     */
    public void like(Product product) {
        //TODO
    }
    
}
