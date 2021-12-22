package Persist;

import Core.Delivery;
import java.sql.*;
import java.util.ArrayList;

public class DeliveryDaoMySQL implements DeliveryDao {

    //SINGLETON
    private static DeliveryDaoMySQL deliveryDaoMySQL;

    private AbstractFactoryDao creator;
    private Connection con;

    /**
     * Constructor of DeliveryDaoMySQL
     * @param creator
     */
    private DeliveryDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
        this.con = this.creator.getConnection();
    }

    public static DeliveryDaoMySQL getDeliveryDaoMySQL(AbstractFactoryDao creator) {
        if(deliveryDaoMySQL == null) {
            deliveryDaoMySQL = new DeliveryDaoMySQL(creator);
        }
        return deliveryDaoMySQL;
    }

    /**
     * Get a delivery from the MySQL DB by ID
     * @param id
     * @return the associated delivery from the MySQL DB
     */
    @Override
    public Delivery getDeliveryById(int id) {
        String requete = "SELECT * from deliveries where id = \""+id+"\"";
        Delivery delivery = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                delivery = new Delivery(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getBoolean(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delivery;
    }

    public ArrayList<Delivery> getDeliveries() {
        String requete = "SELECT * from deliveries";
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        Delivery delivery = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                delivery = new Delivery(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getBoolean(5));
                deliveries.add(delivery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    public Delivery addDelivery(Delivery d) {
        String requete = "INSERT INTO deliveries VALUES (?, ?, ?, ?, ?)";
        Delivery delivery = null;
        try{
            Statement stmt = this.con.createStatement();
            PreparedStatement deliveryStatement = con.prepareStatement(requete);
            deliveryStatement.setInt(1, d.getId());
            deliveryStatement.setInt(2, d.getSellerId());
            deliveryStatement.setInt(3, d.getBuyerId());
            deliveryStatement.setInt(4, d.getProductId());
            deliveryStatement.setBoolean(5, d.getIsDelivered());
            deliveryStatement.executeUpdate();
            delivery = d;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return delivery;
    }

    public ArrayList<Delivery> getDeliveryForUser(int userId) {
        String requete = "SELECT * from deliveries where sellerId = \""+userId+"\"OR buyerId =\""+userId+"\"";
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        Delivery delivery = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                delivery = new Delivery(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getBoolean(5));
            deliveries.add(delivery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }
}