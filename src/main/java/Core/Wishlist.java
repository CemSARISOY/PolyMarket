package Core;

public class Wishlist extends AbstractProdcutList {

    /**
     * Constructor of Wishlist
     * @param id
     * @param productList
     * @param title
     */
    public Wishlist(int id, int user, String title, int productList) {
        super(id,user, title, productList);
    }

    /**
     * Add all items from products to the cart
     */
    public void addAllToCart() {
        //TODO
    }

}
