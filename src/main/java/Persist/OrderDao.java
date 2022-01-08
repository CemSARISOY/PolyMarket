package Persist;

import java.util.ArrayList;

import Core.Order; 
import Core.User;

public interface OrderDao{

    public void createOrder(Cart cart, boolean isPayed); 
        
    public ArrayList<Order> getOrdersSold(int sellerId);

    public ArrayList<Order> getOrdersPurchase(int userId); 

}