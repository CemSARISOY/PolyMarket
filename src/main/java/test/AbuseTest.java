package test;

import org.junit.jupiter.api.Test;

import Core.Abuse;
import Persist.AbstractFactoryDao;
import Persist.AbuseDAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class AbuseTest {
    
    @Test
    void completeAbuseDaoTest(){
        boolean worksfine = true;

        AbuseDAO ad = AbstractFactoryDao.getFactory("mysql").createAbuseDao();
        ad.addAbuse("TESTING", "description", 1, 1);
        List<Abuse> list = ad.getAbuses();
        Abuse a = list.get(list.size()-1);
        if(!a.getTitle().equals("TESTING")) worksfine = false;
        if (worksfine) ad.deleteAbuseById(a.getId());

        assertTrue(worksfine);
    }
}
