package test;

import org.junit.jupiter.api.Test;

import Core.Product;
import Core.User;
import Persist.AbstractFactoryDao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
public class ProductTest {

    
    @Test
    void alreadyLikedTest(){
        // User 1 already has an entry for the Product 3

        boolean thrown = false;
        try{
            AbstractFactoryDao.getFactory("mysql").createProductDao().like(new Product(3,"","","",null,"",null,1.0,new Date(),false), new User(1, "","","","","",new Date(),false,1.0));
        }catch(Exception e){
            thrown = true;
        }

        assertTrue(thrown);
    }
    
}
