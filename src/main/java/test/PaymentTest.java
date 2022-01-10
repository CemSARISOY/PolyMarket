package test;

import org.junit.jupiter.api.Test; 
import Core.CartFacade;
import Core.PaymentFacade;
import Core.Product; 
import Core.User;
import Persist.AbstractFactoryDaoMySQL;
import Persist.OrderDao;
import Persist.ProductDao;
import Persist.UserDao;

import static org.junit.jupiter.api.Assertions.assertTrue; 

public class PaymentTest {
    @Test
    void getBalanceAfterPayment() { 
        try { 
            AbstractFactoryDaoMySQL af = AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL();
            UserDao udao = af.createUserDao();
            ProductDao pdao = af.createProductDao(); 
            User u = udao.getUserByNickname("cemsarisoy");
            Product p = pdao.getProductById(3); // if 1, assertion = false bc buyer = seller
            CartFacade cart = CartFacade.getCartFacade();
            cart.addProduct(p); 
            new PaymentFacade().pay(cart, true);
            User newU = udao.getUserByNickname("cemsarisoy"); 
            assertTrue(newU.getBalance() == u.getBalance() - p.getPrice()); // if buyer != seller
        } catch (Exception e) {  
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new PaymentTest()).getBalanceAfterPayment();
    }
}
