package Persist;

import Core.Product;
import Core.User;

public interface ProductDao{
    public String createProduct(Product product);
    public void updateProduct(String id,Product product);
    public void addToCart(Product product, Cart cart);
    public void purchase(Product product);
    public void like(Product product);
    public Product[] getProductByuser(User user);
    public Product[] getProductbyCategory(String categorie );
    public Product[] getProductByAuthor(User user);
    public String getProductByid (String id);

} 