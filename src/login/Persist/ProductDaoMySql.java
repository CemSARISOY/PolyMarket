package Persist;

import Core.Product;
import Core.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Core.Cart;

/**
* @generated
*/
public class ProductDaoMySql implements ProductDao {

    private AbstractFactoryDao creator;

    public ProductDaoMySql(AbstractFactoryDao creator){
        this.creator = creator;
    }

    @Override
    public int createProduct(String name, String token, String content, int idCategory, String body, int idUser, double price, Date startDate) {
        String requete = "INSERT INTO products VALUES("+name+","+token+","+content+","+idCategory+","+body+","+idUser+","+price+","+startDate+") RETURNING id";
        Connection con = creator.getConnection();
        int id = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void updateProduct(Product product) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void purchase(Product product) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void like(Product product) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Product[] getProductByuser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product[] getProductbyCategory(String categorie) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product[] getProductByAuthor(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product getProductByid(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    
}
