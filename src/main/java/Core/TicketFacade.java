package Core;

import Persist.AbstractFactoryDao;
import Persist.TicketDao;

import java.util.ArrayList;

public class TicketFacade {

    private Ticket actualTicket;
    private ArrayList<Ticket> listTickets;
    private ArrayList<TicketCategory> ticketCategories;

    //DAO's
    private AbstractFactoryDao abstractFactoryDao;
    private TicketDao ticketDao;

    //SINGLETON
    private static TicketFacade ticketFacade;

    private TicketFacade(){}

    public static TicketFacade getTicketFacade() {
        if(ticketFacade == null) {
            ticketFacade = new TicketFacade();
        }
        return ticketFacade;
    }

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
    public void setListTickets(ArrayList<Ticket> listTickets) {
        this.listTickets = listTickets;
    }

    /**
     * Send the ticket to the system
     * @param ticket
     */
    public void send(Ticket ticket) throws Exception {
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        ticketDao = abstractFactoryDao.createTicketDao();
        ArrayList<Ticket> tickets;
        try{
            ticketDao.sendTicket(ticket);
        }
        catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<TicketCategory> getTicketCategories() throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        ticketDao = abstractFactoryDao.createTicketDao();
        ticketCategories = ticketDao.getTicketCategories();
        if(ticketCategories != null){
            return ticketCategories;
        }
        throw new Exception("Error while getting the ticket categories");
    }

}
