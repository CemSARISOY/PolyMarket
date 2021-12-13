package Persist;

import Core.Abuse;

public interface AbuseDAO {

    /**
     * 
     * @return A list of all the abuses stored in the DB
     */
    public Abuse[] getAbuses();

    /**
     * 
     * @param The Abuse to send to the DB
     */
    public void addAbuse(Abuse ab);

    /**
     * 
     * @param The id of the Abuse to delete
     */
    public void deleteAbuseById(int id);
    
}
