package Persist;

import Core.Product;
import Core.ProductCategory;
import Core.User;

import java.sql.Date;

import Core.Cart;

public interface ProductDao{
    public int createProduct(String name, String token, String content, int idCategory, String body, int idUser, double price, Date startDate);
    public void updateProduct(Product product);
    public void purchase(Product product);
    public void like(Product product);
    public Product[] getProductByuser(User user);
    public Product[] getProductbyCategory(String categorie );
    public Product[] getProductByAuthor(User user);
    public Product getProductByid (int id);

} 