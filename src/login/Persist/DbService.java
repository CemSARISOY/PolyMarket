package Persist;
import java.sql.*;  

public class DbService {
    public static Connection callDB(){  

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