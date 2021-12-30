package Persist;

import Core.Wishlist;

import java.sql.*;
import java.util.ArrayList;

public class WishlistDaoMySQL implements WishlistDao {

    private AbstractFactoryDao creator;
    private Connection con;

    //SINGLETON
    private static WishlistDaoMySQL wishlistDaoMySQL;

    /**
     * Constructor of AbstractFactoryDao
     */
    private WishlistDaoMySQL(AbstractFactoryDao c) {
        con = c.getConnection();
    }

    public static WishlistDaoMySQL getWishlistDaoMySQL(AbstractFactoryDao creator){
        if(wishlistDaoMySQL == null) {
            wishlistDaoMySQL = new WishlistDaoMySQL(creator);
        }
        return wishlistDaoMySQL;
    }

    @Override
    public void sendWishlist(Wishlist wl) throws Exception {
        String requete = "INSERT INTO wishlists VALUES (?, ?, ?, ?)";
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement ticketStatement = con.prepareStatement(requete);
            ticketStatement.setInt(1, wl.getId());
            ticketStatement.setInt(2, wl.getUserId());
            ticketStatement.setString(3, wl.getTitle());
            ticketStatement.setInt(4, wl.getProducts());
            ticketStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while adding the wishlist");
        }
    }

    @Override
    public Wishlist getWishlistyById(int id) {
        return null;
    }

    @Override
    public ArrayList<Wishlist> getWishlistsFromUser(int id) throws Exception {
        String requete = "SELECT * from wishlists where userId = \"" + id + "\"";
        ArrayList<Wishlist> wishlists = new ArrayList<Wishlist>();
        Wishlist wishlist = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()){
                wishlist = new Wishlist(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getInt(4));
                wishlists.add(wishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while getting the wishlists");
        }
        return wishlists;
    }

    @Override
    public void deleteWishlistById(int id) throws Exception{
        String requete = "DELETE FROM wishlists where id = " + id;
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement deleteStatement = con.prepareStatement(requete);
            deleteStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while deleting the wishlist");
        }
    }
}