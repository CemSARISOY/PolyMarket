package Persist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core.Auction;
import Core.Product;
import Core.ProductCategory;
import Core.User;

/**
* @generated
*/
public class AuctionDaoMySql implements AuctionDao {

    private AbstractFactoryDao creator;
    private UserDao userDao;
    private ProductDao productDao;

    public AuctionDaoMySql(AbstractFactoryDao creator){
        this.creator = creator;
        userDao = creator.createUserDao();
        productDao = creator.createProductDao();
    }

    @Override
    public void participate(Auction auc, User user, double offer) {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String requete = "INSERT INTO bid VALUES ("+false+","+auc.getId()+","+user.getId()+","+offer+","+sqlDate+")";
        Connection con = creator.getConnection();
        Auction auction = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Auction getAuctionById(int id) {
        String requete = "SELECT * from auction where id = " + id;
        Connection con = creator.getConnection();
        Auction auction = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                auction = new Auction(rs.getInt(1), rs.getDouble(2), rs.getBoolean(3), userDao.getUserById(rs.getInt(4)), rs.getDate(5),
                        rs.getDouble(6), productDao.getProductById(rs.getInt(7)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auction;
    }

    @Override
    public List<Auction> getAuctionByCategory(ProductCategory category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Auction> getAllAuctions() {
        String requete = "SELECT * from auction";
        Connection con = creator.getConnection();
        List<Auction> auctions = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                auctions.add(new Auction(rs.getInt(1), rs.getDouble(2), rs.getBoolean(3), userDao.getUserById(rs.getInt(4)), rs.getDate(5),
                        rs.getDouble(6), productDao.getProductById(rs.getInt(7))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auctions;
    }

    @Override
    public void deleteAuction(int id) {
        String requete = "DELETE FROM auction WHERE id = "+id;
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateAuction(Auction auction) {
        String requete = "UPDATE auction SET amount = "+auction.getAmount()+", endDate = "+ auction.getEndDate()+", idProduct = "+ auction.getProduct().getId()+" WHERE id = "+auction.getId();
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public int createAuction(double baseAmount, Date endDate, Product p) throws Exception {
        String requete = "INSERT INTO auction(amount,isWon,idWinner,endDate,highestOffer,idProduct) VALUES(\'"+baseAmount+"\',"+false+","+null+",\'"+endDate+"\',"+null+","+p.getId()+")";
        Connection con = creator.getConnection();
        int id = 0;
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
            if(rows > 0){
                ResultSet rs = stmt.getGeneratedKeys();
                while (rs.next())
                    id = rs.getInt(1);
            }else{
                throw new Exception("auction was not correctly created");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    
    
    
}
