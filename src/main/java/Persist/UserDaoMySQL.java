package Persist;

import Core.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoMySQL implements UserDao {

    //SINGLETON
    private static UserDaoMySQL userDaoMySQL;

    private AbstractFactoryDao creator;
    private Connection con;

    private UserDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
        this.con = creator.getConnection();
    }

    public static UserDaoMySQL getUserDaoMySQL(AbstractFactoryDao creator) {
        if(userDaoMySQL == null) {
            userDaoMySQL = new UserDaoMySQL(creator);
        }
        return userDaoMySQL;
    }

    @Override
    public User getUserById(int id) {
        String requete = "SELECT * from users where id = " + id;
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