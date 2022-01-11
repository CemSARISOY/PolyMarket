package Persist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core.Abuse;

/**
* @generated
*/
public class AbuseDAOMySQL implements AbuseDAO {

    private AbstractFactoryDao creator;

    public AbuseDAOMySQL(AbstractFactoryDao creator){
        this.creator = creator;
    }

    @Override
    public List<Abuse> getAbuses() {
        String requete = "SELECT * from abuse";
        Connection con = creator.getConnection();
        List<Abuse> abuses = new ArrayList<>();
        UserDao ud = creator.createUserDao();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()) abuses.add(new Abuse(rs.getInt(1), rs.getString(2), rs.getString(3), ud.getUserById(rs.getInt(4)), ud.getUserById(rs.getInt(5))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abuses;
    }

    @Override
    public void addAbuse(String title, String description, int u1, int u2) {
        String requete = "INSERT INTO abuse(title,description,idUser,idUserTarget) VALUES(\'"+title+"\',\'"+description+"\',"+u1+","+u2+")";
        Connection con = creator.getConnection();

        try {
            Statement stmt = con.createStatement();
            stmt.execute(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteAbuseById(int id) {
        String requete = "DELETE FROM abuse WHERE id =" + id;
        Connection con = creator.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
