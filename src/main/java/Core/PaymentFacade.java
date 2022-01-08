package Core;

import Persist.AbstractFactoryDao;
import Persist.Cart; 

public class PaymentFacade {
     
    private AbstractFactoryDao abstractFactoryDAO = AbstractFactoryDao.getFactory("mysql");  
       
    public void makeBid() {
        //TODO
    }  
    
    public void pay(CartFacade cart, boolean isPayed) {
        // REMOVE PRODUCTS FROM AUTHOR AND ADD IT TO BUYER

        abstractFactoryDAO.createOrderDao().createOrder(cart, isPayed);

        // FONCTIONS NON DEFINIS MAIS CEST CENSE MARCHE

        User b = LoginFacade.getLoginFacade().getUser();
        b.setBalance(b.getBalance() - cart.getTotalPrice()); 
        abstractFactoryDAO.createUserDao().modifyUser(b.getId(), b.getFirstname(), b.getLastname(), b.getNickname(), b.getEmail(), b.getPassword(), b.getDob());

        for(Product p : cart.getItemsInCart()) { 
            User seller = p.getAuthor();
            seller.setBalance(seller.setBalance(seller.getBalance() + p.getPrice()));
            abstractFactoryDAO.createUserDao().modifyUser(seller.getId(), seller.getFirstname(), seller.getLastname(), seller.getNickname(), seller.getEmail(), seller.getPassword(), seller.getDob());
        }
    }
}
