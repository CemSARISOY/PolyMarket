package Core;

import Persist.AbstractFactoryDao;
import Persist.WishlistDao;

public class ListWishlistsFacade {

    //SINGLETON
    private static ListWishlistsFacade listWishlistsFacade;

    //DAO'S
    private AbstractFactoryDao abstractFactoryDao;
    private WishlistDao wishlistDao;

    /**
     * Constructor of ListWishlistsFacade
     */
    private ListWishlistsFacade() {
    }

    public static ListWishlistsFacade getListWishlistsFacade(){
        if(listWishlistsFacade == null){
            listWishlistsFacade = new ListWishlistsFacade();
        }
        return listWishlistsFacade;
    }


    /**
     * Add a wishlist to wishlists
     * @param wishlist
     */
    public void addWishlist(Wishlist wishlist) {
        //TODO
    }
}
