package Persist;

import Core.ProductCategory;

public interface CategoryDao {

    ProductCategory getCategoryById(int id);
    
}
