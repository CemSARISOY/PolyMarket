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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Wishlist))
            return false;
        Wishlist w2 = (Wishlist) obj;
        if (this.getId() != w2.getId() || !this.getTitle().equals(w2.getTitle()) || this.getUserId() != w2.getUserId() )
            return false;
        return true;
    }

}
