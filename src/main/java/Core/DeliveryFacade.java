package Core;

import Persist.AbstractFactoryDao;
import Persist.AbstractFactoryDaoMySQL;
import Persist.DeliveryDao;
import Persist.ProductDao;
import Persist.UserDao;

import java.util.ArrayList;

public class DeliveryFacade {

    //SINGLETON
    private static DeliveryFacade deliveryFacade;

    private Delivery delivery;

    //DAO's
    private AbstractFactoryDao abstractFactoryDao;
    private UserDao userDao;
    private DeliveryDao deliveryDao;
    private ProductDao productDao;

    /**
     * Constructor of DeliveryFacade
     */
    private DeliveryFacade() { }

    public static DeliveryFacade getDeliveryFacade() {
        if(deliveryFacade == null) {
            deliveryFacade = new DeliveryFacade();
        }
        return deliveryFacade;
    }

    public Delivery getDeliveryById(int id) {
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");}
        deliveryDao = abstractFactoryDao.createDeliveryDao();
        Delivery delivery = deliveryDao.getDeliveryById(id);
        return delivery;
    }

    public User getSellerFromDelivery(Delivery d) {
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        userDao = abstractFactoryDao.createUserDao();
        User u = userDao.getUserById(d.getSellerId());
        return u;
    }

    public User getBuyerFromDelivery(Delivery d) {
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");}
        userDao = abstractFactoryDao.createUserDao();
        User u = userDao.getUserById(d.getBuyerId());
        return u;
    }

    public Product getProductFromDelivery(Delivery d) {
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");}
        productDao = abstractFactoryDao.createProductDao();
        Product p = productDao.getProductById(d.getProductId());
        return p;
    }


    /**
     * Deliver the product from the buyer (me) to the seller 
     * @param buyer
     * @param seller
     * @param product
     */
    public Delivery deliver(User buyer, User seller, Product product) throws Exception {
        //CALLING DAO'S
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");}
        userDao = abstractFactoryDao.createUserDao();
        deliveryDao = abstractFactoryDao.createDeliveryDao();

        //UPDATING THE OWNER OF THE PRODUCT
        userDao.updatePossess(buyer.getId(), product.getId());

        //CREATING THE DELIVERY ASSOCIATED
        this.delivery = new Delivery(seller.getId(),buyer.getId(),product.getId(),true);

        //SENDING THE DELIVERY TO THE DB
        this.delivery = deliveryDao.addDelivery(this.delivery);
        if(this.delivery != null) {
        	//SEND NOTIFFICATIONS
        	NotificationFacade notificationFacade = new NotificationFacade(abstractFactoryDao.createNotificationDao());
        	Notification notifToSendBuyer =  notificationFacade.createNotification("Delivery", "Your command has been delivered ! Thank you for your purchase ;)");
        	notificationFacade.sendNotifications(notifToSendBuyer, buyer);
        	Notification notifToSendSeller =  notificationFacade.createNotification("Sold", "Your product "+product.getName()+" has been sold ! Congratulations !");
        	notificationFacade.sendNotifications(notifToSendSeller, seller);
            return this.delivery;
        }
        else{
            throw new Exception("Error while adding the delivery");
        }
    } 
}
