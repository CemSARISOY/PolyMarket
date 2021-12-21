package Core;

import Persist.AbstractFactoryDao;
import Persist.DeliveryDao;
import Persist.ProductDao;
import Persist.UserDao;

import java.util.ArrayList;

public class DeliveryFacade {  

    private AbstractFactoryDao abstractFactoryDao;

    private Delivery delivery;
    private UserDao userDao;
    private DeliveryDao deliveryDao;
    private ProductDao productDao;

    /**
     * Constructor of DeliveryFacade
     */
    public DeliveryFacade() { }

    public User getSellerFromDelivery(Delivery d) {
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");}
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

        //UPDATING OWNER PRODUCTS
        ArrayList<Product> pown = buyer.getProducts();
        pown.add(product);
        buyer.setProducts(pown);
        userDao.updateUser(buyer);

        //UPDATING SELLER PRODUCTS
        ArrayList<Product> psell = seller.getProducts();
        int indexofProdSell = psell.indexOf(product);
        psell.remove(indexofProdSell);
        seller.setProducts(psell);
        userDao.updateUser(seller);

        //CREATING THE DELIVERY ASSOCIATED
        this.delivery = new Delivery(1,seller.getId(),buyer.getId(),product.getId(),true);

        //SENDING THE DELIVERY TO THE DB
        this.delivery = deliveryDao.addDelivery(this.delivery);
        if(this.delivery != null) {
            return this.delivery;
        }
        else{
            throw new Exception("Error while adding the delivery");
        }
    } 
}
