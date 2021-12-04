package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import Core.User;
import Persist.UserDaoMySQL;

class UserDaoMySQLTest {
  
  @Test
  void getUserByNicknameTest(){
    UserDaoMySQL dao = new UserDaoMySQL();
    User u = dao.getUserByNickname("cemsarisoy");
    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
    Date d;
    try {
      d = df.parse("2021-12-01");
        assertEquals(new User(1,"cem","sarisoy","cemsarisoy","cemsarisoy@yahoo.es","cemcem",d), u);
      } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
