package Persist;

import java.sql.Connection;

public class AbstractFactoryDaoMySql extends AbstractFactoryDao {

    @Override
    public UserDao createUserDao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection() {
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
