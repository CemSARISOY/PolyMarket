package Persist;

import Core.Product;
import Core.ProductCategory;
import Core.ProductFacade;
import Core.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core.Cart;

/**
* @generated
*/
public class ProductDaoMySQL implements ProductDao {

    private AbstractFactoryDao creator;
    private static ProductDaoMySQL productDaoMySQL;

    private ProductDaoMySQL(AbstractFactoryDao creator){
        this.creator = creator;
    }

    public static ProductDaoMySQL getProductDaoMySQL(AbstractFactoryDao creator) {
        if(productDaoMySQL == null) {
            productDaoMySQL = new ProductDaoMySQL(creator);
        }
        return productDaoMySQL;
    }

    @Override
    public int createProduct(String name, String token, String content, int idCategory, String body, int idUser, double price, Date startDate) throws Exception {
        String requete = "INSERT INTO products(name,token,content,categoryId,body,author,price,startDate,sold) VALUES(\'"+name+"\',\'"+token+"\',\'"+content+"\',\'"+idCategory+"\',\'"+body+"\',\'"+idUser+"\',\'"+price+"\',\'"+startDate+"\',\'"+0+"\')";
        Connection con = creator.getConnection();
        int id = 0;
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
            if(rows > 0){
                ResultSet rs = stmt.getGeneratedKeys();
                while (rs.next())
                    id = rs.getInt(1);
            }else{
                throw new Exception("product was not correctly created");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void updateProduct(Product product) {
        String requete = "UPDATE auction SET name = "+product.getName()+", token = "+ product.getToken()+", content = "+ product.getContent()+", categoryId = "+product.getCategory().getId()+",body = "+product.getBody()+",author="+product.getAuthor().getId()+", price="+product.getPrice()+",startDate="+product.getStartDate()+" WHERE id = "+product.getId();
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void like(Product product) {
        // TODO Auto-generated method stub
        
    }

    private List<Product> getter(String query){
        String requete = query;
        Connection con = creator.getConnection();
        CategoryDao categoryDao = creator.createCategoryDao(); 
        UserDao userDao = creator.createUserDao();
        List<Product> products = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), categoryDao.getCategoryById(rs.getInt(5)), rs.getString(6),
                                        userDao.getUserById(rs.getInt(7)), rs.getInt(8), rs.getDate(9), rs.getBoolean(10) ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getProducts() {
        return getter("select * from products");
    }

    @Override
    public List<Product> getProductByUser(User user) {
        String requete = "SELECT * from possess where idUser = " + user.getId();
        Connection con = creator.getConnection();
        List<Product> products = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                products.add(getProductById(rs.getInt(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getProductbyCategory(ProductCategory category) {
        return getter("select * from products where categoryId = "+ category.getId());
    }

    @Override
    public List<Product> getProductByAuthor(User user) {
        return getter("select * from products where author = "+user.getId());
    }

    @Override
    public Product getProductById(int id) {
        String requete = "SELECT * from products where id = " + id;
        Connection con = creator.getConnection();
        CategoryDao categoryDao = creator.createCategoryDao(); 
        UserDao userDao = creator.createUserDao();
        Product product = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), categoryDao.getCategoryById(rs.getInt(5)), rs.getString(6),
                userDao.getUserById(rs.getInt(7)), rs.getInt(8), rs.getDate(9), rs.getBoolean(10) );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        String requete = "DELETE FROM products WHERE id = "+ id;
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
