package Persist;

import Core.Order;
import Core.User;
import java.sql.*;
import java.util.ArrayList; 
 
public class OrderDaoMySql implements OrderDao {

    private AbstractFactoryDao creator;

    public OrderDaoMySql(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    @Override
    public String createOrder(Cart cart) {
        // TODO Auto-generated method stub
        return null;
    } 

    @Override
    public void updateOrder(String id, Order order) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Order[] getOrdersSold(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Order> getOrdersPurchase(int userId) {
        String requete = "SELECT * from orders where userId = " + userId;
        Connection con = creator.getConnection();
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getBoolean(3));
                System.out.println(order);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    } 
}
