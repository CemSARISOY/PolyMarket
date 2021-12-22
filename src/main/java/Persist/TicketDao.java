package Persist;

import Core.Ticket;
import Core.TicketCategory;

import java.util.ArrayList;

public interface TicketDao {

    public void sendTicket(Ticket t) throws Exception;

    public ArrayList<TicketCategory> getTicketCategories();

    public ArrayList<Ticket> getTickets();
}
