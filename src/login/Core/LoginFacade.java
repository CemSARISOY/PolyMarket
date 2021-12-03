package Core;

import Persist.*; 

public class LoginFacade {

    private AbstractFactoryDao abstractFactoryDao;

    private UserDao userDao;

    private User user;

    public UserDao getUserDao() {
        return new UserDaoMySQL();
    }

    public User getUser() {
        return user;
    }

    public AbstractFactoryDao getAbstractFactoryDao() {
        return abstractFactoryDao;
    }

    public void set(AbstractFactoryDao abstractFactoryDao) {

    }

    public User login(String nick, String pw) throws Exception{
        if(this.abstractFactoryDao == null) abstractFactoryDao = new AbstractFactoryDaoMySQL();
        if(this.userDao == null) userDao = abstractFactoryDao.createUserDao();

        this.user = userDao.getUserByNickname(nick);
        if(user == null) throw new Exception("User doesn't exist");
        if(!user.getPassword().equals(pw)) throw new Exception("Password doesn't match");
        return user;
    }

    
}
