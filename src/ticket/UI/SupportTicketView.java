package UI; 
 
import java.awt.event.ActionListener;
 
public class SupportTicketView implements ActionListener { 
      
    private WishlistFacade ticketFacade = new TicketFacade();
    
    /**
     * Send a ticket using user inputs
     * @param titleTicket
     * @param body
     * @param category
     * @param userEmail
     */
    public send(String titleTicket, String body, Category category, String userEmail) {
        //TODO
    }
    
}
