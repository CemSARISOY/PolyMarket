package Persist;

import java.util.ArrayList;

import Core.Order;
import Core.Orders_Products;

public interface Orders_ProductsDAO {

    public void createOrder_Product(int orderId, int productId); 
        
    public ArrayList<Orders_Products> getOrders_ProductsByOrderId(int orderId); 
}