package Persist;

import Core.User;

public interface TicketDao {
 
    /**
     * Get the ticket from the DB by Ticket ID
     * @param id
     * @return the associated ticket from the DB
     */
    Ticket getTicketById(int id); 
}