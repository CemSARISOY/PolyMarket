package Persist;

import java.util.ArrayList;

import Core.Category;
import Core.ProductCategory;

public interface CategoryDao {

    /**
     * 
     * @return a list of all the categories stored
     */
    public ArrayList<Category> getCategories();

    /**
     * 
     * @param The id of the category in the DB
     */
    public void deleteCategoryById(int id);

    /**
     * 
     * @param The Category to send
     */
    public void addCategory(Category c);

    /**
     * 
     * @param The Category to update
     */
    public void updateCategory(Category c);

    public Category getCategoryById(int id);


    
}
