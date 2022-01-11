package Core;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Persist.AbstractFactoryDao;
import Persist.AuctionDao;
import UI.AuctionView;

/** Class AuctionFacade
* @generated
*/
public class AuctionFacade {
    
     /** instance of AuctionFacade (Singleton)
    */
    private static AuctionFacade instance = new AuctionFacade();
     /** product facade associated to the auctionFacade
    */
    private ProductFacade productFacade;
     /**product of the auction
    */
   
    private AbstractFactoryDao abstractFactoryDao ;
    
    private AuctionDao auctionDao ;
    
    
   
    
    /** get the instance of ActionFacade ( Singleton )
     * @return AuctionFacade
     */
    public static AuctionFacade getAuctionFacade() {
        return AuctionFacade.instance;
    }
    
    
    private AuctionFacade(){
        abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        auctionDao = abstractFactoryDao.createAuctionDao();
        productFacade = ProductFacade.getProductFacade();
    }
    
    

    /** Create an Auction in the database 
     * @param auction The auction to be created 
     * @return The id of the new auction
     */
    public int createAuction(String title, double price, String nft, String body, File f, double duration) {
        int id = productFacade.createProduct(title, price, nft, body, f);
        Product p = productFacade.getProductById(id);
        Date endDate = Calendar.getInstance().getTime();
        endDate.setDate(endDate.getDate() + (int)duration);
        try {
            return auctionDao.createAuction(price, new java.sql.Date(endDate.getTime()), p);
        } catch (Exception e) {
            //TODO: handle exception
            return -1;
        }
    }
   
    
    /** Update an auction in the database 
     * @param newAuction the auction with the changes
     * * @param id id of the auction to update 
     */
    public void updateAuction(int id,Auction newAuction) {
        //TODO
    }
   
    
    /** Delete an auction of the database
     * @param auction The auction to delete
     */
    public void deleteAuction(Auction auction) {
        
    }
   
    
    /** Get the all the auctions
     * @return Auction[]
     */
    public List<Auction> getAllAuctions() {
        return auctionDao.getAllAuctions();
    }
   
    
    /** Get the auctions in the database by the category of their product
     * @param category category of the product
     * @return Auction[]
     */
    public List<Auction> getAuctionByCategory(ProductCategory category) {
        //TODO
        return null;    
    }
   
    
    /** get the auction by id in the database 
     * @param id id of the auction to look for
     * @return Auction
     */
    public Auction getAuctionById(int id ) {
        return auctionDao.getAuctionById(id);
    }
   
     /** Method which let an user participate at an auction
      * @param user the user whi participate
      * @param offer the offer tha propose the user ( the offer has to be uppper than the highest offer of the auction)
     */
    public void participate(double offer, Auction a) throws Exception{
        User u = LoginFacade.getLoginFacade().getUser();
        if(offer <= a.getHighestOffer()){
            throw new Exception("You cannot bid less than the highest amount already bid");
        }else{
            auctionDao.participate(a, u, offer);
        }   
        
    }
    
}
