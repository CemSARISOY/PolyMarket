package Core;

import Persist.AbstractFactoryDao;
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
    private Product product;
    
   
    private AbstractFactoryDao abstractFactoryDao ;
    
    private AuctionView auctionView ;
    
   
    private Auction auction ;
    
    
   
    
    /** get the instance of ActionFacade ( Singleton )
     * @return AuctionFacade
     */
    public AuctionFacade getInstance() {
        return AuctionFacade.instance;
    }
    
    
    private AuctionFacade(){}
    
   
    
    /** Get the product of the auction
     * @return Product
     */
    public Product getProduct() {
        return this.product;
    }
    
   
    
    /** Set the product of the auction
     * @param product
     */
    public void set(Product product) {
        this.product = product ;
    }
    
   
    
    /** Get the AuctionView
     * @return AuctionView
     */
    public AuctionView getAuctionView() {
        return this.auctionView;
    }
    
  
    
   
    
    /** Get the auction
     * @return Auction
     */
    public Auction getAuction() {
        return this.auction;
    }
    
   
    
    /** Set the auction
     * @param auction
     */
    public void setAuction(Auction auction ) {
        this.auction = auction ;
    }
    
   
    
    /** Get the AbstractFactoryDao
     * @return AbstractFactoryDao
     */
    public AbstractFactoryDao getAbstractFactoryDao() {
        return this.abstractFactoryDao;
    }
    

    /** Create an Auction in the database 
     * @param auction The auction to be created 
     * @return String The id of the new auction
     */
    public String createAuction(Auction auction) {
        return null;
    }
   
    
    /** Update an auction in the database 
     * @param newAuction the auction with the changes
     * * @param id id of the auction to update 
     */
    public void updateAuction(String id,Auction newAuction) {
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
    public Auction[] getAllAuctions() {
        return null;
    }
   
    
    /** Get the auctions in the database by the category of their product
     * @param category category of the product
     * @return Auction[]
     */
    public Auction[] getAuctionByCategory(ProductCategory category) {
        //TODO
        return null;    
    }
   
    
    /** get the auction by id in the database 
     * @param id id of the auction to look for
     * @return Auction
     */
    public Auction getAuctionById(String id ) {
        //TODO
        return null;
    }
   
     /** Method which let an user participate at an auction
      * @param user the user whi participate
      * @param offer the offer tha propose the user ( the offer has to be uppper than the highest offer of the auction)
     */
    public void participate(User user, int offer) {
        //TODO
    }
    
}
