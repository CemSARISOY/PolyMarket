package Persist;

import java.util.ArrayList; 
import Core.Order;
import Core.Orders_Products;

import java.sql.*; 

public class Orders_ProductsDAOMySQL implements Orders_ProductsDAO{

    private AbstractFactoryDao creator;

    public Orders_ProductsDAOMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }
 
    @Override
    public void createOrder_Product(int orderId, int productId) { 
        String requete = "INSERT INTO orders_products (id, orderId, productId) VALUES (null, " + orderId + ", " + productId + ")";
        Connection con = creator.getConnection(); 
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(requete);  
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    @Override
    public ArrayList<Orders_Products> getOrders_ProductsByOrderId(int orderId) {
        String requete = "SELECT * from orders_products where orderId = " + orderId;
        Connection con = creator.getConnection();
        ArrayList<Orders_Products> orders = new ArrayList<Orders_Products>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()) {
                Orders_Products op = new Orders_Products(rs.getInt(1), rs.getInt(2), rs.getInt(3)); 
                orders.add(op);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    } 
}
