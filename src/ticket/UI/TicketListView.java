package UI;
 
import java.awt.event.ActionListener;
 
public class TicketListView implements ActionListener {
 
    private ArrayList<Ticket> listTickets;
     
    /**
     * Getter of listTickets
     * @return
     */
    public ArrayList<Ticket> getListTickets() {
        return this.listTickets;
    }

    /**
     * Setter of listTickets
     * @param listTickets
     */
    public void setListTickets(Wishlist listTickets) {
        this.listTickets = listTickets;
    }
     
    /**
     * Event activated when the user clicks on a specific ticket
     */
    public void onTicketClick() {
        //TODO
    }
    
}
