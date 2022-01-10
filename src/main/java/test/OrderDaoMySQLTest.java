package test;

import Core.Category;
import Core.Order;
import Core.User;
import Persist.AbstractFactoryDaoMySQL;
import Persist.CategoryDao;
import Persist.OrderDao;
import Persist.UserDao;
import org.junit.jupiter.api.Test; 
import java.util.ArrayList;   
import static org.junit.jupiter.api.Assertions.assertTrue; 

class OrderDaoMySQLTest {

    @Test
    void getOrderByIdTest() {
        AbstractFactoryDaoMySQL af = AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL();
        UserDao udao = af.createUserDao();
        OrderDao odao = af.createOrderDao();
        User u = udao.getUserByNickname("cemsarisoy");
        ArrayList<Order> o = odao.getOrdersPurchase(u.getId());  
        try {   
            assertTrue(true == o.get(0).getIsPaid());
        } catch (Exception e) {  
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new OrderDaoMySQLTest()).getOrderByIdTest();
    }
} 