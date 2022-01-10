package test;

import Core.Category; 
import Persist.AbstractFactoryDaoMySQL;
import Persist.CategoryDao; 
import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.assertTrue; 

class CategoryDaoMySQLTest {

    @Test
    void getCategoryByIdTest() {
        AbstractFactoryDaoMySQL af = AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL(); 
        CategoryDao cdao = af.createCategoryDao(); 
        Category c = cdao.getCategoryById(1);
        try {    
            assertTrue(new Category(1, "GIF").getId() == c.getId());
            assertTrue(new Category(1, "GIF").getName().equals(c.getName()));
        } catch (Exception e) {  
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new CategoryDaoMySQLTest()).getCategoryByIdTest();
    }
}