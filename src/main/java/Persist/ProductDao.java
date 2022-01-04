package Persist;

import Core.Product;
import Core.ProductCategory;
import Core.User;

import java.sql.Date;
import java.util.List;

public interface ProductDao{
    public int createProduct(String name, String token, String content, int idCategory, String body, int idUser, double price, Date startDate);
    public void updateProduct(Product product);
    public void like(Product product);
    public List<Product> getProducts();
    public List<Product> getProductByUser(User user);
    public List<Product> getProductbyCategory(ProductCategory category);
    public List<Product> getProductByAuthor(User user);
    public Product getProductById (int id);

}
