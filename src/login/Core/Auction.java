package Core;

import java.util.Date;

/** Class Auction
* @generated
*/
public class Auction {
    
  
    private int id;
    
  
    private float amount;
    
  
    private Boolean isWon;
    
  
    private User winner;
    
  
    private Date endDate;
    
  
    private Integer highestOffer;
    
    
  
    private AuctionFacade auctionFacade;
    
    
  
    
    /** Get the id of the auction
     * @return int
     */
    public int getId() {
        return this.id;
    }
    
  
    
    /** Set the id of the auction
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
  
    
    /** Get the ammount of the auction
     * @return float
     */
    public float getAmount() {
        return this.amount;
    }
    
  
    
    /**  Set the ammount of the auction
     * @param amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
  
    
    /** get a bool which represent if the aucion has been won or nor
     * @return Boolean
     */
    public Boolean getIsWon() {
        return this.isWon;
    }
    
  
    
    /** Set the isWon attribute of auction
     * @param isWon
     */
    public void setIsWon(Boolean isWon) {
        this.isWon = isWon;
    }
    
  
    
    /** Get the user who won the auction if the auction isWon
     * @return User
     */
    public User getWinner() {
        return this.winner;
    }
    
  
    
    /** Set the winner attribute of Auction
     * @param winner
     */
    public void setWinner(User winner) {
        this.winner = winner;
    }
    
  
    
    /** Get the end Date of the auction
     * @return Date
     */
    public Date getEndDate() {
        return this.endDate;
    }
    
  
    
    /** Set the end date of the auction
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
  
    
    /** Get the highest offer of the auction
     * @return Integer
     */
    public Integer getHighestOffer() {
        return this.highestOffer;
    }
    
  
    
    /** Set the highest offer of the auction
     * @param highestOffer
     */
    public void setHighestOffer(Integer highestOffer) {
        this.highestOffer = highestOffer;
    }
    
    
  
    
    /** Get the Auction Facade
     * @return AuctionFacade
     */
    public AuctionFacade get() {
        return this.auctionFacade;
    }
    
  
    
    /** Set the auction Facade
     * @param auctionFacade
     */
    public void set(AuctionFacade auctionFacade ) {
        this.auctionFacade = auctionFacade;
    }
    
}
