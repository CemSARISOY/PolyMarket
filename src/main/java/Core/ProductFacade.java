package Core;

import Persist.AbstractFactoryDao;
import Persist.ProductDao;

public class ProductFacade {

    //DAO's
    private AbstractFactoryDao abstractFactoryDao;
    private ProductDao productDao;

    //SINGLETON
    private static ProductFacade productFacade;

    private ProductFacade(){}

    public static ProductFacade getProductFacade() {
        if(productFacade == null) {
            productFacade = new ProductFacade();
        }
        return productFacade;
    }

    public Product getProductById(int id){
        if (this.abstractFactoryDao == null){
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        }
        productDao = abstractFactoryDao.createProductDao();
        Product product = null;
        try{
            product = productDao.getProductById(id);
        }
        catch (Exception e){
            throw e;
        }
        return product;
    }
}
