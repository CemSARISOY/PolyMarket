package Core;

import Persist.*;

public class LoginFacade {

    //SINGLETON
    private static LoginFacade loginFacade;

    private LoginFacade(){}

    public static LoginFacade getLoginFacade() {
        if(loginFacade == null) {
            loginFacade = new LoginFacade();
        }
        return loginFacade;
    }

    private AbstractFactoryDao abstractFactoryDao;

    private User user;

    /**
     * Returns the user currently logged
     * 
     * @return User object
     */
    public User getUser(int id) {
        return user;
    }

    public User getUserById(int id) throws Exception{
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        UserDao userDao = abstractFactoryDao.createUserDao();
        this.user = userDao.getUserById(id);
        if (user == null){
            throw new Exception("User doesn't exist");
        }
        return user;
    }

    /**
     * Tries to log the user in the system with the specified credentials
     * 
     * @param nick nickname typed in the interface
     * @param pw   password typed in the interface
     * @return a {@code User} if the user was correctly logged
     * @throws Exception if the user doesn't exist, or the password doesn't match
     */
    public User login(String nick, String pw) throws Exception {
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        UserDao userDao = abstractFactoryDao.createUserDao();

        this.user = userDao.getUserByNickname(nick);
        if (user == null)
            throw new Exception("User doesn't exist");
        if (!user.getPassword().equals(pw))
            throw new Exception("Password doesn't match");
        return user;
    }

}
