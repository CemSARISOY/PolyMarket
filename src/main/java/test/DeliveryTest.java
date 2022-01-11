package test;

import static org.junit.Assert.assertTrue;

import Persist.AbstractFactoryDao;
import Persist.DeliveryDao;
import org.junit.Test;

import Core.Delivery;

public class DeliveryTest {

    @Test
    void getDeliveryTest() {
        AbstractFactoryDao abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        DeliveryDao deliveryDao = abstractFactoryDao.createDeliveryDao();
        Delivery delivery = new Delivery(1,1,2,1,true);
        Delivery delivery1 = deliveryDao.getDeliveryById(1);
        try{
            assertTrue(delivery.equals(delivery1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
