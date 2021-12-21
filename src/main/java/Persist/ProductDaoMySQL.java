package Persist;

import Core.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDaoMySQL implements ProductDao {

    private AbstractFactoryDao creator;
    private Connection con;

    public ProductDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    @Override
    public Product getProductById(int id) {
        String requete = "SELECT * from products where id = " + id;
        Connection con = creator.getConnection();
        Product product = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                product = new Product(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
