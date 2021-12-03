package Persist;

import java.sql.*;
import Core.User;

public class UserDaoMySQL implements UserDao {

    @Override
    public User getUserById(int id) {
        var requete = "SELECT * from users where id = " + id;
        var con = DbService.callDB();
        User user = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete); 
            while(rs.next())  
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));   
            con.close(); 
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }  
        return user;
    }
    
    public User getUserByNickname(String nickname) {
        var requete = "SELECT * from users where nickname = " + nickname;
        var con = DbService.callDB();
        User user = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete); 
            while(rs.next())  
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));   
            con.close(); 
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }  
        return user;
    }  
}