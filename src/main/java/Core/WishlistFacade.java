package Core;

import Persist.AbstractFactoryDao;
import Persist.WishlistDao;

import java.util.ArrayList;

public class WishlistFacade {

    //SINGLETON
    private static WishlistFacade wishlistFacade;

    //DAO'S
    private AbstractFactoryDao abstractFactoryDao;
    private WishlistDao wishlistDao;

    /**
     * Constructor of AbstractFactoryDao
     */
    private WishlistFacade() {
    }

    public static WishlistFacade getWishlistFacade(){
        if(wishlistFacade == null) {
            wishlistFacade = new WishlistFacade();
        }
        return wishlistFacade;
    }

    public void createWishlist(Wishlist wl) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        wishlistDao = abstractFactoryDao.createWishlistDao();
        try{
            wishlistDao.sendWishlist(wl);
        }
        catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Wishlist> getWishlistsFromUser(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        wishlistDao = abstractFactoryDao.createWishlistDao();
        ArrayList<Wishlist> wishlists;
        try{
            wishlists = wishlistDao.getWishlistsFromUser(id);
        }
        catch (Exception e) {
            throw e;
        }
        return wishlists;
    }

    public void deleteWishlistById(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        wishlistDao = abstractFactoryDao.createWishlistDao();
        try{
            wishlistDao.deleteWishlistById(id);
        }
        catch (Exception e) {
            throw e;
        }
    }

    /**
     * Add a product to the actualWishlist's products (WishlistFacade)
     * @param product
     */
    public void addProduct(Product product) {
        //TODO
    }
}