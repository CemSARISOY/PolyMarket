package Persist;

import java.sql.Date;
import java.util.List;

import Core.User;

public interface UserDao {

    /**
     * Get a User in the database
     * 
     * @param id of the user in the database
     * @return a {@code User} object if the query was correct, {@code null}
     *         otherwise
     */
    User getUserById(int id);

    /**
     * Get a User in the database
     * 
     * @param nickname selected by the user when creating his account
     * @return a {@code User} object if the query was correct, {@code null}
     *         otherwise
     */
    User getUserByNickname(String nickname);



    /**
     * Signs up the user in the database
     * 
     * @param nickname User's nick name
     * @param password User's password
     * @param firstname User's firstname
     * @param lastname User's lastname
     * @param email User's email
     * @param dob User's date of birth
     * 
     * @throws Exception when the nickname already exists
     * 
     */
    void signUp(String nickname, String password, String firstname, String lastname, String email, Date dob) throws Exception;

    /**
     * Gets all the users in the database
     * 
     * @return {@code List<User>} a list of users
     */
    List<User> getAllUsers();
    
    /**
     * Delete a user in the database based of an ID
     * 
     * @param id id of the user to delete
     * @return {@code User} the deleted user
     * 
     * @throws Exception when the id doesn't associate to any user
     */
    User deleteUser(int id) throws Exception;

    /**
     * Modifies the user in the database based of an ID
     * 
     * @param id id of the user to delete
     * @param nickname new nickname of the user
     * @param firstname new firstname of the user
     * @param lastname new lastname of the user
     * @param email new email of the user
     * @param dob new date of birth of the user
     * 
     * @return the {@code User} with the new attributes
     * 
     * @throws Exception when the id doesn't associate to any user or when the new nickname already exists
     */
    User modifyUser(int id, String nickname, String firstname, String lastname, String email, Date dob);

}
