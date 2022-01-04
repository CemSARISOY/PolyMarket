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

    public Wishlist getWishlistById(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        wishlistDao = abstractFactoryDao.createWishlistDao();
        Wishlist wishlist;
        try{
            wishlist = wishlistDao.getWishlistyById(id);
            if(wishlist == null){
                throw new Exception("Wishlist doesn't exists");
            }
        }
        catch (Exception e) {
            throw e;
        }
        return wishlist;
    }

    public void deleteProductFromWishlistById(int wishId, int productid) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        wishlistDao = abstractFactoryDao.createWishlistDao();
        try {
            wishlistDao.deleteProductFromWishlistById(wishId,productid);
        }
        catch (Exception e) {
            throw new Exception("Error while deleting the product from the Wishlist");
        }
    }

    public ArrayList<Product> getProductsFromWishlistId(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        wishlistDao = abstractFactoryDao.createWishlistDao();
        ArrayList<Product> products;
        try{
            products = wishlistDao.getProductsFromWishlistId(id);
        }
        catch (Exception e) {
            throw e;
        }
        return products;
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
     * Add a product to the user's cart (WishlistFacade)
     * @param productId
     * @param userId
     */
    public void addToCart(int productId, int userId) throws Exception {
        //TODO
    }
}