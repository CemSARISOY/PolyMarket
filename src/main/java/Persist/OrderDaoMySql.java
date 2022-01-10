package Persist;

import Core.CartFacade;
import Core.LoginFacade;
import Core.Order;
import Core.Product;
import Core.ProductCategory;
import Core.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date; 
 
public class OrderDaoMySql implements OrderDao {

    private AbstractFactoryDao creator;

    public OrderDaoMySql(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    @Override
    public void createOrder(CartFacade cart, boolean isPayed) {
        var isPayedNewFormat = isPayed ? 1 : 0;
        String requete = "INSERT INTO orders (id, userId, isPayed) VALUES (NULL, " + LoginFacade.getLoginFacade().getUser().getId() + ", " + isPayedNewFormat + ")";
        Connection con = creator.getConnection(); 
        int insertedId = -1;
        try {
            PreparedStatement stmt = con.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);;
            stmt.executeUpdate();   
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertedId = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
        
                if (insertedId != -1) {
                    Orders_ProductsDAOMySQL orders_ProductsDAOMySQL = new Orders_ProductsDAOMySQL(creator); 
                    for(Product p : cart.getItemsInCart()) {
                        orders_ProductsDAOMySQL.createOrder_Product(insertedId, p.getId());
                    }
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    } 
 
    @Override
    public ArrayList<Order> getOrdersSold(int sellerId) {
        String requete = "SELECT * from orders where sellerId = " + sellerId;
        Connection con = creator.getConnection();
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(4)); 
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
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
                Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(4)); 
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    } 
}
