package Core;

import java.util.List;

import Persist.AbstractFactoryDao;
import Persist.AbuseDAO;
import Persist.UserDao;
import UI.UserViewAbuse;

/**
* @generated
*/
public class AbuseFacade {
    
    private static AbuseFacade abuseFacade = new AbuseFacade();

    private AbstractFactoryDao abstractFactoryDao;
    private AbuseDAO abuseDAO;
    private UserDao userDAO;
    private Abuse report;
    private User user;
    
    public static AbuseFacade getAbuseFacade(){
        return abuseFacade;
    }

    private AbuseFacade(){
        if (this.abstractFactoryDao == null)
            abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        abuseDAO = abstractFactoryDao.createAbuseDao();
        userDAO = abstractFactoryDao.createUserDao();

    }

    /**
    Getters and setters
    */
    public Abuse getReport() {
        return this.report;
    }
    
    public void setReport(Abuse report) {
        this.report = report;
    }
    
    public AbstractFactoryDao getAbstractFactoryDAO() {
        return this.abstractFactoryDao;
    }
    
    public void setAbstractFactoryDAO(AbstractFactoryDao abstractFactoryDAO) {
        this.abstractFactoryDao = abstractFactoryDAO;
    }


    //Operations                                  
    public void sendAbuse(String title, String description, int targetId) {
        User source = LoginFacade.getLoginFacade().getUser();

        abuseDAO.addAbuse(title, description, source.getId(), targetId);

    }

    public void sendWarning() {
        //TODO
    }

    public void banUser() {
        //TODO
    }

    public void delAbuse() {
        
        abuseDAO.deleteAbuseById(report.getId());
    }

    public List<Abuse> consult() {

        List<Abuse> abuses = abuseDAO.getAbuses();
        return abuses;
    }
    
}
