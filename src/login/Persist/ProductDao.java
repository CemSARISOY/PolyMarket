package Persist;

import java.util.List;

import Core.Product;
import Core.User;

public interface ProductDao {

    List<Product> getProductsByUser(User u);
    
}
