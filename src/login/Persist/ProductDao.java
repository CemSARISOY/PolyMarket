package Persist;

import java.util.List;

import Core.Product;
import Core.User;

public interface ProductDao {

    /**
     * TODO dans le product management
     */
    List<Product> getProductsByUser(User u);
    
}
