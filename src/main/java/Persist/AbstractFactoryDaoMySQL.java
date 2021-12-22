package Persist;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractFactoryDaoMySQL extends AbstractFactoryDao {

    //SINGLETON
    private static AbstractFactoryDaoMySQL abstractFactoryDaoMySQL;

    private AbstractFactoryDaoMySQL() {
    }

    public static AbstractFactoryDaoMySQL getAbstractFactoryDaoMySQL() {
        if(abstractFactoryDaoMySQL == null) {
            abstractFactoryDaoMySQL = new AbstractFactoryDaoMySQL();
        }
        return abstractFactoryDaoMySQL;
    }

    Connection con;


    public UserDao createUserDao() {
        return UserDaoMySQL.getUserDaoMySQL(this);
    }

    public ProductDao createProductDao() {
        return ProductDaoMySQL.getProductDaoMySQL(this);
    }

    public DeliveryDao createDeliveryDao() {
        return DeliveryDaoMySQL.getDeliveryDaoMySQL(this);
    }

    public TicketDao createTicketDao() {return TicketDaoMySQL.getTicketDaoMySQL(this);}

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
