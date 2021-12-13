package Persist;

import java.sql.*;
import java.util.List;

import Core.User;

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


    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User deleteUser(int id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void signUp(String nickname, String password, String firstname, String lastname, String email, Date dob) throws Exception{
        // TODO Auto-generated method stub
        
    }

    @Override
    public User modifyUser(int id, String nickname, String firstname, String lastname, String email, Date dob) {
        // TODO Auto-generated method stub
        return null;
    }
}