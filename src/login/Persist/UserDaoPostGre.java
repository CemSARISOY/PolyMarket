package Persist;

import java.sql.*;

import Core.User;

public class UserDaoPostGre implements UserDao {

    public User getUserById(int id) {
        var requete = "SELECT * from users where id = " + id;
        var con = DbService.callDB();
        User user = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user.s);
        return user;
    }
}
