package Core;

public class Wishlist extends AbstractProdcutList {

    /**
     * Constructor of Wishlist when id is know (received from DB)
     * @param id
     * @param title
     * @param userId
     */
    public Wishlist(int id, int userId, String title) {
        super(id,userId, title);
    }

    public Wishlist(int userId, String title){
        super(userId, title);
    }

    /**
     * Add all items from products to the cart
     */
    public void addAllToCart() {
        //TODO
    }

}
