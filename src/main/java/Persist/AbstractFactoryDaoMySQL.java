package Persist;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractFactoryDaoMySQL extends AbstractFactoryDao {

    Connection con;

    public UserDao createUserDao() {
        return new UserDaoMySQL(this);
    }

    public ProductDao createProductDao() {
        return new ProductDaoMySQL(this);
    }

    public DeliveryDao createDeliveryDao() {
        return new DeliveryDaoMySQL(this);
    }

    public Connection getConnection() {
        try {
            if (con == null)
                con = DriverManager.getConnection("jdbc:mysql://eu01-db.cus.mc-panel.net/db_442584", "db_442584",
                        "9bfc0fd115");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
