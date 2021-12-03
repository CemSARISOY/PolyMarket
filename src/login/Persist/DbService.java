package Persist;
import java.sql.*;  

public class DbService {
    public static Connection callDB(){  
        // try{  
        // Class.forName("com.mysql.cj.jdbc.Driver");  
        // Connection con=DriverManager.getConnection(  
        // "jdbc:mysql://eu01-db.cus.mc-panel.net/db_442584","db_442584","9bfc0fd115");  
        // //here sonoo is database name, root is username and password  
        // Statement stmt=con.createStatement();  
        // ResultSet rs=stmt.executeQuery("select * from users");  
        // while(rs.next())  
        // System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + " " + rs.ge);  
        // con.close();  
        // }catch(Exception e){ System.out.println(e);}  
        // }   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://eu01-db.cus.mc-panel.net/db_442584","db_442584","9bfc0fd115");  
            return con;
        } catch (Exception e) {
            System.out.println(e);
        } 
        return null;
    }
} 