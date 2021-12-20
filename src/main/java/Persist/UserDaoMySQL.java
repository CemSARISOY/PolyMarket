package Persist;

import Core.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoMySQL implements UserDao {

    private AbstractFactoryDao creator;

    public UserDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    @Override
    public User getUserById(int id) {
        String requete = "SELECT * from users where id = " + id;
        Connection con = creator.getConnection();
        User user = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByNickname(String nickname) {
        String requete = "SELECT * from users where nickname = \"" + nickname + "\"";
        Connection con = creator.getConnection();
        User user = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next())
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User u){
        return;
    }
}