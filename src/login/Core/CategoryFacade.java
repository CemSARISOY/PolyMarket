package Core;

import java.util.ArrayList;

import Persist.AbstractFactoryDao;
import Persist.CategoryDao;

/**
* @generated
*/
public class CategoryFacade {
    
    private AbstractFactoryDao abstractFactoryDao; 
    private CategoryDao catDAO;
    
    /**
    Getters and setters
    */
    
    public CategoryDao getCatDAO() {
        return this.catDAO;
    }
    
    public CategoryDao setCatDAO(CategoryDao catDAO) {
        this.catDAO = catDAO;
        return this.catDAO;
    }
    
    public AbstractFactoryDao getAbstractFactoryDAO() {
        return this.abstractFactoryDao;
    }
    
    public AbstractFactoryDao setAbstractFactoryDAO(AbstractFactoryDao abstractFactoryDAO) {
        this.abstractFactoryDao = abstractFactoryDAO;
        return this.abstractFactoryDao;
    }

    //Operations   
    public ArrayList<Category> getCateogries() {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        CategoryDao categoryDao = abstractFactoryDao.createCategoryDao(); 
        return categoryDao.getCategories();
    }
    
    public void updateCategory(Category cat) {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        CategoryDao categoryDao = abstractFactoryDao.createCategoryDao(); 
        categoryDao.updateCategory(cat);;
    }

    public void createCat(Category cat) {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        CategoryDao categoryDao = abstractFactoryDao.createCategoryDao(); 
        categoryDao.addCategory(cat);;
    }

    public void deleteCat(int id) {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        CategoryDao categoryDao = abstractFactoryDao.createCategoryDao(); 
        categoryDao.deleteCategoryById(id);;
    }

    public void searchCat() {
        //TODO
    }

    public void selectCat() {
        //TODO
    }
    
}
