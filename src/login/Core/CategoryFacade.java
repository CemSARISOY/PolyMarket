package Core;

import Persist.AbstractFactoryDao;
import Persist.CatDAO;

/**
* @generated
*/
public class CategoryFacade {
    
    private AbstractFactoryDao abstractFactoryDAO;
    private Category category;
    private CatDAO catDAO;
    
    /**
    Getters and setters
    */
    public Category getCateogry() {
        return this.category;
    }
    
    public Category setCategory(Category cat) {
        this.category = cat;
        return this.category;
    }
    
    public CatDAO getCatDAO() {
        return this.catDAO;
    }
    
    public CatDAO setCatDAO(CatDAO catDAO) {
        this.catDAO = catDAO;
        return this.catDAO;
    }
    
    public AbstractFactoryDao getAbstractFactoryDAO() {
        return this.abstractFactoryDAO;
    }
    
    public AbstractFactoryDao setAbstractFactoryDAO(AbstractFactoryDao abstractFactoryDAO) {
        this.abstractFactoryDAO = abstractFactoryDAO;
        return this.abstractFactoryDAO;
    }

    //Operations                                  
    public void createCat() {
        //TODO
    }

    public void deleteCat() {
        //TODO
    }

    public void searchCat() {
        //TODO
    }

    public void selectCat() {
        //TODO
    }
    
}
