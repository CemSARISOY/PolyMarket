package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Core.User;
import Persist.AbstractFactoryDaoMySQL;
import Persist.UserDao;

class UserDaoMySQLTest {

    @Test
    void getUserByNicknameTest() {
        AbstractFactoryDaoMySQL af = new AbstractFactoryDaoMySQL();
        UserDao dao = af.createUserDao();
        User u = dao.getUserByNickname("cemsarisoy");
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date d;
        try {
            d = s.parse("2021-12-01");
            assertTrue(new User(1, "cem", "sarisoy", "cemsarisoy", "cemsarisoy@yahoo.es", "cemcem", d).equals(u));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            fail(e.getMessage());
            e.printStackTrace();
        }
    }
}
