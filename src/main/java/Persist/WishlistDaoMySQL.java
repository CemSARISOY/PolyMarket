package Persist;

import Core.Product;
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
        String requete = "INSERT INTO wishlists VALUES (?, ?, ?)";
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement wishStatement = con.prepareStatement(requete);
            wishStatement.setNull(1, 1);
            wishStatement.setInt(2, wl.getUserId());
            wishStatement.setString(3, wl.getTitle());
            wishStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while adding the wishlist");
        }
    }

    @Override
    public Wishlist getWishlistyById(int id) throws Exception{
        String requete = "SELECT * from wishlists where id = \"" + id + "\"";
        Wishlist wishlist = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()){
                wishlist = new Wishlist(rs.getInt(1), rs.getInt(2), rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while getting the wishlists");
        }
        return wishlist;
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
                wishlist = new Wishlist(rs.getInt(1), rs.getInt(2), rs.getString(3));
                wishlists.add(wishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while getting the wishlists");
        }
        return wishlists;
    }

    @Override
    public ArrayList<Product> getProductsFromWishlistId(int id) throws Exception {
        String requete = "SELECT P.id , P.name, P.token, P.content, P.categoryId, P.body, P.author,P.price,P.startDate" +
                " from wishes W join products P ON P.id = W.productId where W.wishlistId = \"" + id + "\"";
        ArrayList<Product> products = new ArrayList<Product>();
        Product product = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()){
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getString(6),
                        rs.getInt(7), rs.getDouble(8), rs.getDate(9));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while getting the products from wishslist");
        }
        return products;
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

    @Override
    public void deleteProductFromWishlistById(int wishId, int productId) throws Exception{
        String requete = "DELETE FROM wishes where productId = \"" + productId + "\" and wishlistId = \"" + wishId + "\"";
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement deleteStatement = con.prepareStatement(requete);
            deleteStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while deleting the product from the wishlist");
        }
    }
}