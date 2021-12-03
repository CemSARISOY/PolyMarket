package Persist;


public class AbstractFactoryDaoPostGre implements AbstractFactoryDao {

    public UserDaoPostGre createUserDao() {
        return new UserDaoPostGre();
    }  
}
