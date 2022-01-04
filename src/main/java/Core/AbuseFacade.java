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
    
    private AbstractFactoryDao abstractFactoryDao;
    private AbuseDAO abuseDAO;
    private UserDao userDAO;
    private Abuse report;
    private User user;
    

    public AbuseFacade(){
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
    public void sendAbuse(String title, String description, String nickname) {
        User target = userDAO.getUserByNickname(nickname);
        User source = LoginFacade.getInstance().getUser();

        abuseDAO.addAbuse(title, description, source.getId(), target.getId());

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
