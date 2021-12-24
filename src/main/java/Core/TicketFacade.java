package Core;

import Persist.AbstractFactoryDao;
import Persist.JavaMailService;
import Persist.TicketDao;
import Persist.UserDao;

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
    public ArrayList<Ticket> getListTickets() throws Exception{
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

    public void deleteTicketById(int id) throws Exception{
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        ticketDao = abstractFactoryDao.createTicketDao();
        try {
            ticketDao.deleteTicketById(id);
        }
        catch (Exception e) {
            throw new Exception("Error while deleting the ticket");
        }
    }

    public void sendAnswer(Ticket t, User u, String ans) throws Exception {
        //UPDATING TICKET
        ticketDao.updateAnswerTicket(t.getId());

        //SENDING EMAIL
        String senderEmail = "valent.taqz@gmail.com"; //TO BE REPLACED BY u.getEmail();
        try {
            sendEmail(senderEmail,ans,t.getTitle());
        } catch (Exception e) {
            throw e;
        }
    }

    private void sendEmail(String to, String ans, String title) throws Exception{
        try {
            String from = "polymarkethelp@gmail.com";
            String subject = "Feedback from your recent ticket";
            String text = "Ticket title : "+title+"<br><br>"+"Answer from our support staff :<br>"+ans;

            // Call the mail service to send the message
            JavaMailService.send(from, to, subject, text, null, null, null);

        } catch (Exception e) {
            throw new Exception("Error while sending the mail");
        }
    }
}
