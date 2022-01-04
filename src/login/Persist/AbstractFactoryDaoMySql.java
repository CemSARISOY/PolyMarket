package Persist;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractFactoryDaoMySQL extends AbstractFactoryDao {

    //SINGLETON
    private static AbstractFactoryDaoMySQL abstractFactoryDaoMySQL;

    Connection con;

    private AbstractFactoryDaoMySQL() {
    }

    public static AbstractFactoryDaoMySQL getAbstractFactoryDaoMySQL() {
        if(abstractFactoryDaoMySQL == null) {
            abstractFactoryDaoMySQL = new AbstractFactoryDaoMySQL();
        }
        return abstractFactoryDaoMySQL;
    }

    public Connection getConnection() {
        try {
            if (con == null){
                con = DriverManager.getConnection("jdbc:mysql://eu01-db.cus.mc-panel.net/db_442584", "db_442584",
                        "9bfc0fd115");
            }
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDao createUserDao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductDao createProductDao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AuctionDao createAuctionDao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CategoryDao createCategoryDao() {
        // TODO Auto-generated method stub
        return null;
    }

}
