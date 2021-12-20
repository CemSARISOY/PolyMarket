package Core;

import Persist.AbstractFactoryDao;
import Persist.DeliveryDao;
import Persist.UserDao;

import java.util.ArrayList;

public class DeliveryFacade {  

    private AbstractFactoryDao abstractFactoryDao;

    private User buyer;
    private User seller;
    private Product product;
    private Delivery delivery;
    private UserDao userDao;
    private DeliveryDao deliveryDao;

    /**
     * Constructor of DeliveryFacade
     */
    public DeliveryFacade() { }
     
    /**
     * Getter of user
     * @return DeliveryFacade's user
    */
    public User getBuyer() {
        return this.buyer;
    } 

    /**
     * Getter of seller
     * @return DeliveryFacade's seller
    */
    public User getSeller() {
        return this.seller;
    }

    /**
     * Getter of product
     * @return DeliveryFacade's product
    */
    public Product getProduct() {
        return this.product;
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
