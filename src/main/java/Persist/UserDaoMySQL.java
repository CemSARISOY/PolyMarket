package Persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import Persist.AbstractFactoryDao;
import Core.Notification;
import Core.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoMySQL implements UserDao {
 
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
                        rs.getString(6), rs.getDate(7), rs.getBoolean(8), rs.getDouble(9));
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
            while (rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getBoolean(8), rs.getDouble(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User[] getAllUser() {
    	
    	// get the number of users to create the set 
    	  String requete = "SELECT COUNT(*) FROM users";
    	  Connection con = creator.getConnection();
    	  int dimension = -1;
    	  try {
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(requete);
              while (rs.next()) {
          
                  dimension = rs.getInt(1);
              }
              
          } catch (SQLException e) {
              e.printStackTrace();
          }
    	
    	// Get the users 
    	
       requete = "SELECT * from users";
       User[] users = new User[dimension];
        User user = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            int i = 0;
            while (rs.next()) {
           
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getBoolean(8), rs.getDouble(9));
                users[i] = user;
                i++;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return users;
    }

    @Override
    public void signUp(String firstname, String lastname,String nickname, String email,String pw, Date dob) {
        String requete = 
        		"INSERT INTO users (firstname, lastname, nickname, email,password,dob) VALUES  (\"" + firstname + "\" , \"" + lastname + "\",\"" + nickname + "\",\"" + email + "\",\"" + pw + "\",\"" + dob + "\");";
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public User deleteUser(int id) {
    	User user = this.getUserById(id);
        String requete = "DELETE from users where id = " + id;
        Connection con = creator.getConnection();
       
        try {
            Statement stmt = con.createStatement();
           stmt.executeUpdate(requete);
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        requete = "DELETE from notifier where id_user = " + id;
        con = creator.getConnection();
      
       try {
           Statement stmt = con.createStatement();
          stmt.executeUpdate(requete);
          
       } catch (SQLException e) {
           e.printStackTrace();
       
       }
       return user;
    }
        
    

    @Override
    public User modifyUser(int id,String firstname, String lastname,String nickname, String email,String pw,Date dob, double balance) {
        String requete = " UPDATE users  SET firstname = \"" + firstname 
        		+ "\", lastname = \"" + lastname + "\", nickname = \"" + nickname 
        		+ "\", email =\"" + email + "\",password = \"" + pw + "\",balance = \"" + balance
        		+"\", dob =\"" + dob + "\"  where id = " + id;
  
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
           stmt.executeUpdate(requete);
           return this.getUserById(id);
           
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
     
        
    }

    public static void main(String args[]) { 
    	AbstractFactoryDao abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
    	UserDaoMySQL userDaoMySql = new UserDaoMySQL(abstractFactoryDao);
    	userDaoMySql.signUp("axel", "laget", "axe25", "UserProfileView@gmail.com","1234",new java.sql.Date(25, 05, 2000));
    	//userDaoMySql.modifyUser(3, "axel", "prosper", "null", "null", "ofdofj@gmail;com", new java.sql.Date(25, 05, 2000));
    	//userDaoMySql.deleteUser(3);
    	User[] test_users = userDaoMySql.getAllUser();
    	for (int i = 0 ; i<test_users.length;i++) {
    		System.out.println(test_users[i].getNickname());
    	}
    	
    }
}