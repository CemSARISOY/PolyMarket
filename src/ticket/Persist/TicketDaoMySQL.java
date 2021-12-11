package TicketDaoMySQL;
 
public class TicketDaoMySQL  implements TicketDao {

    private AbstractFactoryDao creator;

    /**
     * Constructor of TicketDaoMySQL
     * @param creator
     */
    public TicketDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    /**
     * Get the ticket from the MySQL DB by Ticket ID
     * @param id
     * @return
     */
    @Override
    public Ticket getTicketById(int id) {
        // TODO
    }  
}
