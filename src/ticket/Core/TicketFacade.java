package Core;
 
public class TicketFacade {
      
    private AbstractFactoryDao abstractFactoryDao;

    /**
     * Constructor of TicketFacade
     */
    public TicketFacade() {}

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
