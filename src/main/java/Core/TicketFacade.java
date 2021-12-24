package Core;

import Persist.AbstractFactoryDao;
import Persist.TicketDao;
import Persist.UserDao;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import java.util.ArrayList;

public class TicketFacade {

    private Ticket actualTicket;
    private ArrayList<Ticket> listTickets;
    private ArrayList<TicketCategory> ticketCategories;

    //DAO's
    private AbstractFactoryDao abstractFactoryDao;
    private TicketDao ticketDao;
    private UserDao userDao;

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
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        ticketDao = abstractFactoryDao.createTicketDao();
        ArrayList<Ticket> tickets;
        try{
            tickets = ticketDao.getTickets();
        }
        catch (Exception e) {
            throw e;
        }
        return tickets;
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

    public TicketCategory getTicketCategory(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        ticketDao = abstractFactoryDao.createTicketDao();
        TicketCategory ticketCategory;
        ticketCategory = ticketDao.getTicketCategory(id);
        if(ticketCategory != null){
            return ticketCategory;
        }
        throw new Exception("Error while getting the ticket category");
    }

    public User getUserById(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        userDao = abstractFactoryDao.createUserDao();
        User sender;
        sender = userDao.getUserById(id);
        if(sender != null){
            return sender;
        }
        throw new Exception("Error while getting the ticket category");
    }

    public Ticket getTicketById(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        ticketDao = abstractFactoryDao.createTicketDao();
        Ticket ticket;
        ticket = ticketDao.getTicketById(id);
        if(ticket != null){
            return ticket;
        }
        throw new Exception("Error while getting the ticket category");
    }

    public void sendAnswer(Ticket t, User u, String ans) {
        //UPDATING TICKET
        ticketDao.updateAnswerTicket(t.getId());

        //SENDING EMAIL
        String email = u.getEmail();

    }

    public void sendEmail(String to, String ans) {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setSSLOnConnect(true);
        email.setAuthentication("your-account-name@gmail.com", "your-password");
    }

}
