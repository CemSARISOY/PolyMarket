package Persist;
import Core.Order;
import Core.Cart;
import Core.User;

public interface OrderDao{
    public String createOrder(Cart cart);

    public void deleteOrder(String id);

    public void updateOrder(String id, Order order);
        
    public Order[] getOrdersSold(User user);

    public Order[] getOrdersPurchase(User user);

    

}