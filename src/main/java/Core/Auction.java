package Core;

import java.util.Date;

/** Class Auction
* @generated
*/
public class Auction {
    
  
    private int id;
    private double amount;
    private boolean isWon;
    private User winner;
    private Date endDate;
    private double highestOffer;
    private Product product;

  

    public Auction(int id, double amount, boolean isWon, User winner, Date endDate, double highestOffer, Product product) {
        this.id = id;
        this.amount = amount;
        this.isWon = isWon;
        this.winner = winner;
        this.endDate = endDate;
        this.highestOffer = highestOffer;
        this.product = product;
    }
    

    public boolean isWon() {
        return this.isWon;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    

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
     * @return double
     */
    public double getAmount() {
        return this.amount;
    }
    
  
    
    /**  Set the ammount of the auction
     * @param amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
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
    public double getHighestOffer() {
        return this.highestOffer;
    }
    
  
    
    /** Set the highest offer of the auction
     * @param highestOffer
     */
    public void setHighestOffer(double highestOffer) {
        this.highestOffer = highestOffer;
    }
    
    
}
