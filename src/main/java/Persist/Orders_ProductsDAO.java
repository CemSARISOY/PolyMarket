package Persist;

import java.util.ArrayList;

import Core.Order;

public interface Orders_ProductsDAO{

    public void createOrder_Product(int orderId, int productId); 
        
    public ArrayList<Order> getOrders_ProductsByOrderId(int orderId); 
}