package Persist;

import Core.Ticket;
import Core.TicketCategory;

import java.util.ArrayList;

public interface TicketDao {

    public void sendTicket(Ticket t) throws Exception;

    public ArrayList<TicketCategory> getTicketCategories();

    public ArrayList<Ticket> getTickets();

    public TicketCategory getTicketCategory(int id);

    public Ticket getTicketById(int id);

    public void updateAnswerTicket(int id);
}
