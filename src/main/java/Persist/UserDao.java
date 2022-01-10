package Persist;

import java.util.ArrayList;
import java.util.Date;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

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
     * Get all User in the database
     * 
     * 
     * @return a {@code User[]} object if the query was correct, {@code null}
     *         otherwise
     */
    User[] getAllUser();

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
     * */
    void signUp(String firstname, String lastname,String nickname, String email,String pw, Date dob);

    /**
     * Delete a user in the database based of an ID
     * 
     * @param id id of the user to delete
     * @return {@code User} the deleted user
     * 
     */
    User deleteUser(int id);

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
     */
    User modifyUser(int id,String firstname, String lastname,String nickname, String email,String pw, Date dob) ;

    void updatePossess(int buyerId, int productId) throws Exception;

    void addPossess(int userId, int productId) throws Exception;

}
