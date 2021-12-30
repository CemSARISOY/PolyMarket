package Persist;

import Core.Wishlist;

import java.util.ArrayList;

public interface WishlistDao {

    void sendWishlist(Wishlist wl) throws Exception;

    Wishlist getWishlistyById(int id) throws Exception;

    ArrayList<Wishlist> getWishlistsFromUser(int id) throws Exception;

    void deleteWishlistById(int id) throws Exception;
}
