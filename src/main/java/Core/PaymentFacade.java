package Core;

import java.util.List;
import java.util.ArrayList;
import Persist.AbstractFactoryDao;
import Persist.Cart;
import Persist.UserDao; 

public class PaymentFacade {
     
    private AbstractFactoryDao abstractFactoryDAO = AbstractFactoryDao.getFactory("mysql");  
       
    public void makeBid() {
        //TODO
    }  
    
    public void pay(CartFacade cart, boolean isPayed) {
        // REMOVE PRODUCTS FROM AUTHOR AND ADD IT TO BUYER

        abstractFactoryDAO.createOrderDao().createOrder(cart, isPayed);

        // FONCTIONS NON DEFINIS MAIS CEST CENSE MARCHE
 
        User b = abstractFactoryDAO.createUserDao().getUserById(1);
        b.setBalance(b.getBalance() - cart.getTotalPrice()); 
        var u = abstractFactoryDAO.createUserDao();
        u.modifyUser(b.getId(), b.getFirstname(), b.getLastname(), b.getNickname(), b.getEmail(), b.getPassword(), b.getDob(), b.getBalance());

        for(Product p : cart.getItemsInCart()) { 
            User s = u.getUserById(p.getAuthor().getId());
            s.setBalance(s.getBalance() + p.getPrice()); 
            abstractFactoryDAO.createUserDao().modifyUser(s.getId(), s.getFirstname(), s.getLastname(), s.getNickname(), s.getEmail(), s.getPassword(), s.getDob(), s.getBalance());
        } 
        cart.setItemsInCart(new ArrayList<Product>());
    }
}
