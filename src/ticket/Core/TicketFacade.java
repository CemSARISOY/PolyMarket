package Core;

// MAKE IT SINGLETON
public class TicketFacade {
      
    private AbstractFactoryDao abstractFactoryDao; 
    private Ticket actualTicket;
    private ArrayList<Ticket> listTickets;

    /**
     * Constructor of TicketFacade
     */
    public TicketFacade() {}
 
    /**
     * Getter of actualTicket
     * @return TicketListView's actualTicket
     */
    public Ticket getActualTicket() {
        return this.actualTicket;
    } 

    /**
     * Getter of listTickets
     * @return TicketListView's listTickets
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
     * Send the ticket to the system
     * @param titleTicket
     * @param body
     * @param category
     * @param userEmail 
     */
    public void send(String titleTicket, String body, Category category, String userEmail) {
        //TODO
    } 

    /**
     * Answer a ticket from the system
     * @param idTicket
     * @param answer
     */
    public void answer(int idTicket, String answer) {
        //TODO
    }
    
}
