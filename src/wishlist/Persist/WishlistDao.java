package Persist; 

public interface WishlistDao {
 
    /**
     * Get a wishlist from the DB by Wishlist ID
     * @param id
     * @return
     */
    Wishlist getWishlistyById(int id); 
}
