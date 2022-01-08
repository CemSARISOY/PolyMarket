package Core;

import Persist.AbstractFactoryDao;
import Persist.Cart; 

public class PaymentFacade {
     
    private AbstractFactoryDao abstractFactoryDAO = AbstractFactoryDao.getFactory("mysql");  
       
    public void makeBid() {
        //TODO
    }  
    
    public void pay(Cart cart, boolean isPayed) {
        // REMOVE PRODUCTS FROM AUTHOR AND ADD IT TO BUYER

        abstractFactoryDAO.createOrderDao().createOrder(cart, isPayed);

        // FONCTIONS NON DEFINIS MAIS CEST CENSE MARCHE

        // User buyer = LoginFacade.getLoginFacade().getUser();
        // buyer.setBalance(buyer.getBalance() - cart.getTotalPrice());
        // abstractFactoryDAO.createUserDao().updateUser(buyer);

        // for(Product p : cart.getProducts()) { 
        //     User seller = abstractFactoryDAO.createUserDao().getUserById(p.getAuthor());
        //     seller.setBalance(seller.setBalance(seller.getBalance() + p.getPrice()));
        //     abstractFactoryDAO.createUserDao().updateUser(seller);
        // }
    }
}
