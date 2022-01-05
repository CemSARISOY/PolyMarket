package test;

import Core.User;
import Persist.AbstractFactoryDaoMySQL;
import Persist.UserDao;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class UserDaoMySQLTest {

    @Test
    void getUserByNicknameTest() {
        AbstractFactoryDaoMySQL af = AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL();
        UserDao dao = af.createUserDao();
        User u = dao.getUserByNickname("cemsarisoy");
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date d;
        try {
            d = s.parse("2021-12-01");
            assertTrue(new User(1, "cem", "sarisoy", "cemsarisoy", "cemsarisoy@yahoo.es", "cemcem", d, true, 1000d).equals(u));
        } catch (ParseException e) { 
            fail(e.getMessage());
            e.printStackTrace();
        }
    }
}
