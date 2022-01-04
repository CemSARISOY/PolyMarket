package Persist;

import java.sql.Connection;

/**
* @generated
*/
public class AbstractFactoryDaoMySql extends AbstractFactoryDao {
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public AuctionDao createAuctionDao() {
        return new AuctionDaoMySql(this);
        //TODO
    }

    public ProductDao createProductDao(){
        return new ProductDaoMySql(this);
    }

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
    
}
