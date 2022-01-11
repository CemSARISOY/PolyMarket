package test;

import static org.junit.Assert.assertTrue;

import Core.Wishlist;
import Persist.WishlistDao;
import org.junit.Test;

import Persist.AbstractFactoryDao;

public class WishlistTest {

    @Test
    void getWishlistTest() {
        AbstractFactoryDao abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        WishlistDao wishlistDao = abstractFactoryDao.createWishlistDao();
        Wishlist wishlist = new Wishlist(6,1, "pour tiberiu");
        try {
            Wishlist wishlist1 = wishlistDao.getWishlistyById(6);
            assertTrue(wishlist.equals(wishlist1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
