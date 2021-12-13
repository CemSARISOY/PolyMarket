package Core;

import Persist.AbstractFactoryDao;
import Persist.AbuseDAO;
import Persist.UserDao;
import UI.UserViewAbuse;

/**
* @generated
*/
public class AbuseFacade {
    
    private AbstractFactoryDao abstractFactoryDAO;
    private AbuseDAO abuseDAO;
    private UserDao userDAO;
    private Abuse report;
    private User user;
    
    /**
    Getters and setters
    */
    public Abuse getReport() {
        return this.report;
    }
    
    public Abuse setReport(Abuse report) {
        this.report = report;
        return this.report;
    }
    
    public UserDao getUserDAO() {
        return this.userDAO;
    }
    
    public UserDao setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
        return this.userDAO;
    }
    
    public AbuseDAO getAbuseDAO() {
        return this.abuseDAO;
    }
    
    public AbuseDAO setAbuseDAO(AbuseDAO abuseDAO) {
        this.abuseDAO = abuseDAO;
        return this.abuseDAO;
    }
    
    public AbstractFactoryDao getAbstractFactoryDAO() {
        return this.abstractFactoryDAO;
    }
    
    public AbstractFactoryDao setAbstractFactoryDAO(AbstractFactoryDao abstractFactoryDAO) {
        this.abstractFactoryDAO = abstractFactoryDAO;
        return this.abstractFactoryDAO;
    }

    //Operations                                  
    public void sendAbuse() {
        //TODO
    }

    public void sendWarning() {
        //TODO
    }

    public void banUser() {
        //TODO
    }

    public void delAbuse() {
        //TODO
    }

    public void consult() {
        //TODO
    }
    
}
