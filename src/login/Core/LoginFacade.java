package Core;

import Persist.*; 

public class LoginFacade {

    private AbstractFactoryDao abstractFactoryDao; 

    private User user; 

    public User getUser() {
        return user;
    }

    public AbstractFactoryDao getAbstractFactoryDao() {
        return abstractFactoryDao;
    }

    public void set(AbstractFactoryDao abstractFactoryDao) {

    }

    public User login(String nick, String pw) throws Exception{
        if(this.abstractFactoryDao == null) abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        UserDao userDao = abstractFactoryDao.createUserDao();

        this.user = userDao.getUserByNickname(nick);
        if(user == null) throw new Exception("User doesn't exist");
        if(!user.getPassword().equals(pw)) throw new Exception("Password doesn't match");
        return user;
    }

    
}
