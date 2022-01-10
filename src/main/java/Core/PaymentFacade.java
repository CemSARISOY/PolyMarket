package Core;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import Persist.AbstractFactoryDao;
import Persist.Cart;
import Persist.UserDao;
import UI.payment.UserViewPayment; 

public class PaymentFacade {
     
    private AbstractFactoryDao abstractFactoryDAO = AbstractFactoryDao.getFactory("mysql");  
       
    public void makeBid() {
        //TODO
    }  
    
    public void pay(CartFacade cart, boolean isPayed) {
        User b = LoginFacade.getLoginFacade().getUser(); 
        abstractFactoryDAO.createOrderDao().createOrder(cart, isPayed); 
        b.setBalance(b.getBalance() - cart.getTotalPrice()); 
        var u = abstractFactoryDAO.createUserDao();
        u.modifyUser(b.getId(), b.getFirstname(), b.getLastname(), b.getNickname(), b.getEmail(), b.getPassword(), b.getDob(), b.getBalance());

        for(Product p : cart.getItemsInCart()) { 
            User s = u.getUserById(p.getAuthor().getId());
            s.setBalance(s.getBalance() + p.getPrice()); 
            abstractFactoryDAO.createUserDao().modifyUser(s.getId(), s.getFirstname(), s.getLastname(), s.getNickname(), s.getEmail(), s.getPassword(), s.getDob(), s.getBalance());
        } 
    }
}
