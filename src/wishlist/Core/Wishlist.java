package Core;
 
public class Wishlist extends AbstractProdcutList {
 
    /**
     * Constructor of Wishlist
     * @param id
     * @param products
     * @param title
     * @param body
     * @param category
     * @param userEmail
     */
    public Wishlist(int id, ArrayList<Product> products, String title, String body, TicketCategory category, String userEmail) {
        super(id, products, title, body, category, userEmail);
    } 

    /**
     * Add all items from products to the cart
     */
    public void addAllToCart() {
        //TODO
    }
    
}
