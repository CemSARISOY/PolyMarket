package Persist;

import Core.User;

public interface TicketDao {
 
    /**
     * Get the ticket from the DB by Ticket ID
     * @param id
     * @return
     */
    Ticket getTicketById(int id); 
}