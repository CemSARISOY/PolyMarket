package UI;

import javax.swing.JFrame;

import Core.AuctionFacade;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @generated
*/
public class AuctionView implements ActionListener {
    
   
    private JFrame detailledAuctionView;
    
   
    private JFrame AuctionsView;
    
    
    
    private AuctionFacade auctionFacade;
    
    
    
   
 
    
    /** Get the detailled auction view
     * @return JFrame
     */
    public JFrame getDetailledAuctionView() {
        return this.detailledAuctionView;
    }
    
  
    
   
    
    
    /**  Get the auctions view (view of all auctions)
     * @return JFrame
     */
    public JFrame getAuctionsView() {
        return this.AuctionsView;
    }
    
   
    

 
    
    /** Get the auction facade
     * @return AuctionFacade
     */
    public AuctionFacade get() {
        return this.auctionFacade;
    }
    
    
    
    /** Set the auction facade
     * @param auctionFacade
     */
    public void set(AuctionFacade auctionFacade ) {
        this.auctionFacade =auctionFacade ;
    }

    
    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
