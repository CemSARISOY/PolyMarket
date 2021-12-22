package Persist;

import Core.Ticket;
import Core.TicketCategory;

import java.sql.*;
import java.util.ArrayList;

public class TicketDaoMySQL implements TicketDao {

    private AbstractFactoryDao creator;
    private Connection con;

    //SINGLETON
    private static TicketDaoMySQL ticketDaoMySQL;

    private TicketDaoMySQL(AbstractFactoryDao c){
        this.creator = c;
        con = c.getConnection();
    }

    public static TicketDaoMySQL getTicketDaoMySQL(AbstractFactoryDao creator){
        if(ticketDaoMySQL == null) {
            ticketDaoMySQL = new TicketDaoMySQL(creator);
        }
        return ticketDaoMySQL;
    }

    public void sendTicket(Ticket t) throws Exception {
        String requete = "INSERT INTO tickets VALUES (?, ?, ?, ?, ?, ?)";
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement ticketStatement = con.prepareStatement(requete);
            ticketStatement.setInt(1, t.getId());
            ticketStatement.setString(2, t.getTitle());
            ticketStatement.setString(3, t.getBody());
            ticketStatement.setInt(4, t.getCategory());
            ticketStatement.setInt(5, t.getUserId());
            ticketStatement.setBoolean(6, t.getIsAnswered());
            ticketStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error while adding the ticket");
        }
    }

    @Override
    public ArrayList<TicketCategory> getTicketCategories() {
            String requete = "SELECT * from ticketCategories";
            ArrayList<TicketCategory> ticketCategories = new ArrayList<TicketCategory>();
            TicketCategory category = null;
            try {
                Statement stmt = this.con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                while (rs.next())
                    category = new TicketCategory(rs.getInt(1), rs.getString(2));
                ticketCategories.add(category);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ticketCategories;
    }

    @Override
    public ArrayList<Ticket> getTickets() {
        String requete = "SELECT * from tickets";
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Ticket ticket = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
                tickets.add(ticket);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
