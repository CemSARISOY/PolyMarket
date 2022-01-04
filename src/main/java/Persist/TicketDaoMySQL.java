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
            ticketStatement.setNull(1, 1);
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
    public ArrayList<TicketCategory> getTicketCategories() throws Exception{
            String requete = "SELECT * from ticketCategories";
            ArrayList<TicketCategory> ticketCategories = new ArrayList<TicketCategory>();
            TicketCategory category = null;
            try {
                Statement stmt = this.con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                while (rs.next()){
                    category = new TicketCategory(rs.getInt(1), rs.getString(2));
                    ticketCategories.add(category);
                }
            } catch (SQLException e) {
                throw e;
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
            while (rs.next()){
                ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public TicketCategory getTicketCategory(int id) {
        String requete = "SELECT * from ticketCategories where id = \"" + id + "\"";
        TicketCategory category = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                category = new TicketCategory(rs.getInt(1), rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Ticket getTicketById(int id) {
        String requete = "SELECT * from tickets where id = \"" + id + "\"";
        Ticket ticket = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void updateAnswerTicket(int id) {
        String requete = "UPDATE tickets SET isAnswered = ? where id = " + id;
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement updateStatement = con.prepareStatement(requete);
            updateStatement.setBoolean(1, true);
            updateStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicketById(int id) {
        String requete = "DELETE FROM tickets where id = " + id;
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement deleteStatement = con.prepareStatement(requete);
            deleteStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
