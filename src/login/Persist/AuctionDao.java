package Persist;

import Core.Auction;
import Core.User;

public interface AuctionDao {
    
    public void participate(User user,int offer);

    public Auction getAuctionById(String id) ;


    public Auction[] getAuctionByCategory();
        

    public Auction[] getAllAuctions() ;
       
    
    public void deleteAuction(String id) ;
        
    

    public void updateAuction(String id);
    

    public String createAuction(Auction auction);
     
    

}
