package Core;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractProdcutList {
	
	private List<Product> products = new ArrayList<Product>();
    private Integer id = null;
    private String title;
    private int userId;

    /**
     * Constructor of AbstractProdcutList when id is known
     * @param id
     * @param title
     */
    public AbstractProdcutList(int id , int userId,  String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public AbstractProdcutList(int userId,  String title) {
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    /**
     * Getter of title
     * @return AbstractProdcutList's title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter of title
     * @param title AbstractProdcutList's title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    /**
     * adds a product to the list
     * 
     * @param p the product to add
     */
    public void addProduct(Product p) {
        this.products.add(p);
    }
    
    /**
     * deletes a product from the list
     * 
     * @param p the product to delete
     */
    public void deleteProduct(Product p) {
        this.products.remove(p);
    }

    
    /**
     * deletes a product from the list
     * 
     * @param id the id of the product to delete
     */
    public void deleteProductById(int id) {
    	Product productToDelete;
    	 for (Product product : this.products ) {
    		 if (product.getId()==id) {
    			 productToDelete=product;
    		 	  this.products.remove(productToDelete);
    		 	  break;
    		 	  
    		 }
    			 
          }
        
    }


    /**
     * gets the number of items in the list
     * 
     * @return the number of items in the list
     */
    public int getNbItems() {
        return this.products.size();
    }
    
    /**
     * computes the total price of the items in the list
     * 
     * @return the computed price
     */
    public double getTotalPrice() {
    	int sum = 0;
        for (Product product : this.products ) {
        	sum+=product.getPrice();
        }
        return sum;
    }
    
    /**
     * gets all the products in the cart
     * 
     * @return a {@code List} of the products in the cart
     */
    public List<Product> getItemsInCart() {
        
        return this.products;
    }

    
    

}
