package Persist;
 
public class AbstractFactoryDaoMySQL implements AbstractFactoryDao {
    
    public UserDaoMySQL createUserDao() {
        return new UserDaoMySQL();
    }
    
}
