package Persist;

import Core.Ticket;
import Core.TicketCategory;

import java.util.ArrayList;

public interface TicketDao {

    public void sendTicket(Ticket t) throws Exception;

    public ArrayList<TicketCategory> getTicketCategories() throws Exception;

    public ArrayList<Ticket> getTickets() throws Exception;

    public TicketCategory getTicketCategory(int id) throws Exception;

    public Ticket getTicketById(int id) throws Exception;

    public void updateAnswerTicket(int id) throws Exception;

    public void deleteTicketById(int id) throws Exception;
}
