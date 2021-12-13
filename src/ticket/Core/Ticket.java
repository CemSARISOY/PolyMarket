package Core;
 
public class Ticket {
     
    private int id;
    private String title; 
    private String body; 
    private TicketCategory category; 
    private String userEmail;  
    private int status;
     
    /**
     * Constructor of Ticket
     * @param id
     * @param title
     * @param body
     * @param category
     * @param userEmail
     * @param status
     */
    public Ticket(int id, String title, String body, TicketCategory category, String userEmail, int status) {
        this.id = id;
        this.title = title; 
        this.body = body; 
        this.category = category; 
        this.userEmail = userEmail;  
        this.status = status;
    }

    /**
     * Getter of id
     * @return ticket's id
     */
    public int getId() {
        return this.id;
    }  

    /**
     * Getter of title
     * @return ticket's title
     */
    public String getTitle() {
        return this.title;
    } 

    /**
     * Getter of body
     * @return ticket's body
     */
    public String getBody() {
        return this.body;
    }
     
    /**
     * Getter of category
     * @return ticket's category
     */
    public TicketCategory getCategory() {
        return this.category;
    }
     
    /**
     * Getter of userEmail
     * @return ticket's userEmail
     */
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * Getter of status
     * @return user's status
     */
    public String getStatus() {
        return this.status;
    }  

    /**
     * Setter of status
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }  
}
