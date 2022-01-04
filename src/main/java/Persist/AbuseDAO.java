package Persist;

import java.util.List;

import Core.Abuse;

public interface AbuseDAO {

    /**
     * 
     * @return A list of all the abuses stored in the DB
     */
    public List<Abuse> getAbuses();

    /**
     * 
     * @param The Abuse to send to the DB
     */
    public void addAbuse(String title, String description, int u1, int u2);

    /**
     * 
     * @param The id of the Abuse to delete
     */
    public void deleteAbuseById(int id);
    
}
