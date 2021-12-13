package Persist;

import java.sql.*;
import Core.Wishlist;

public class WishlistDaoMySQL implements WishlistDao {

    private AbstractFactoryDao creator;

    /**
     * Constructor of AbstractFactoryDao
     * @param creator
     */
    public WishlistDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    /**
     * Get a wishlist from the MySQL DB by Wishlist ID
     * @param id
     * @return the associated wishlist from the MySQL DB
     */
    @Override
    public Wishlist getWishlistById(int id) {
        // TODO
    } 
}