package Persist;

import Core.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDaoMySQL implements ProductDao {

    //SINGLETON
    private static ProductDaoMySQL productDaoMySQL;

    private AbstractFactoryDao creator;
    private Connection con;

    private ProductDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
        this.con = creator.getConnection();
    }

    public static ProductDaoMySQL getProductDaoMySQL(AbstractFactoryDao creator) {
        if(productDaoMySQL == null) {
            productDaoMySQL = new ProductDaoMySQL(creator);
        }
        return productDaoMySQL;
    }

    @Override
    public Product getProductById(int id) {
        String requete = "SELECT * from products where id = " + id;
        Product product = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()){
                product = new Product(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
