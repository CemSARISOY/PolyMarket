package Persist;

import java.util.ArrayList;

import Core.Order;
import Persist.Cart;
import Core.User;

public interface OrderDao{
    public String createOrder(Cart cart);

    public void updateOrder(String id, Order order);
        
    public Order[] getOrdersSold(User user);

    public ArrayList<Order> getOrdersPurchase(int userId); 

}