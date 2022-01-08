package Persist;

import java.sql.Date;
import java.util.List;

import Core.Auction;
import Core.Product;
import Core.ProductCategory;
import Core.User;

public interface AuctionDao {
    
    public void participate(Auction auc, User user,double offer);

    public Auction getAuctionById(int id) ;

    public List<Auction> getAuctionByCategory(ProductCategory category);

    public List<Auction> getAllAuctions() ;
    
    public void deleteAuction(int id) ;

    public void updateAuction(Auction auction);

    public int createAuction(double baseAmount, Date endDate, Product product) throws Exception;
     
    

}
