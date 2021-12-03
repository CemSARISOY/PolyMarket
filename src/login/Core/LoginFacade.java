package Core;

import Persist.*; 

public class LoginFacade {

    private AbstractFactoryDao abstractFactoryDao;

    private UserDao userDao;

    private User user;

    public UserDao getUserDao() {
        return new UserDaoPostGre();
    }

    public void setUserDao(UserDao userDao) {
        
    }

    // public User getUser() {
    //     return new User();
    // }

    public void setUser(User user) {
        
    }

    public AbstractFactoryDao getAbstractFactoryDao() {
        return new AbstractFactoryDaoPostGre();
    }

    public void set(AbstractFactoryDao abstractFactoryDao) {

    }

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void login(String nick, String pw) {
        
    }
}
