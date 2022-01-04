package Core;

public class TicketCategory {

    private int id;
    private String name;

    public TicketCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter of name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of id
     * @return
     */
    public int getId() {
        return this.id;
    }
}
