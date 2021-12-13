package Persist;

import Core.Category;

public interface CatDAO {

    /**
     * 
     * @return a list of all the categories stored
     */
    public Category[] getCategories();

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

    
}
