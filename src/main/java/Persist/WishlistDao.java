package Persist;

import Core.Product;
import Core.Wishlist;

import java.util.ArrayList;

public interface WishlistDao {

    void sendWishlist(Wishlist wl) throws Exception;

    Wishlist getWishlistyById(int id) throws Exception;

    ArrayList<Wishlist> getWishlistsFromUser(int id) throws Exception;

    void deleteWishlistById(int id) throws Exception;

    ArrayList<Product> getProductsFromWishlistId(int id) throws Exception;

    void deleteProductFromWishlistById(int wishId, int productId) throws Exception;
}
