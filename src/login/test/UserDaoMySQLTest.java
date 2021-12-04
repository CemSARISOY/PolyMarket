package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import Core.User;
import Persist.UserDaoMySQL;

class UserDaoMySQLTest {
  
  @Test
  void getUserByNicknameTest(){
    UserDaoMySQL dao = new UserDaoMySQL();
    User u = dao.getUserByNickname("cemsarisoy");
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    Date d;
    try {
      d = s.parse("2021-12-01");
      assertTrue(new User(1,"cem","sarisoy","cemsarisoy","cemsarisoy@yahoo.es","cemcem",d).equals(u));
      } catch (ParseException e) {
      // TODO Auto-generated catch block
        fail(e.getMessage());
        e.printStackTrace();
    }
  }
}
