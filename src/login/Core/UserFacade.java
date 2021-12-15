package Core;

import java.sql.Date;
import java.util.List;

import Persist.ProductDao;
import Persist.UserDao;

public class UserFacade {
    
    
    private ProductDao productDao;

    private UserDao userDao;
    

    //                          Operations                                  
    

    /**
     * Signs the user up in the application
     * 
     * @param nickname User's nick name
     * @param password User's password
     * @param firstname User's firstname
     * @param lastname User's lastname
     * @param email User's email
     * @param dob User's date of birth
     * 
     * @return {@code true} if the signup was successful, {@code false} otherwise
     */
    public boolean signUp(String nickname, String password, String firstname, String lastname, String email, Date dob) {
        //TODO
        return false;
    }

    /**
     * Disconnects the user from the application
     * 
     */
    public void disconnect() {
        //TODO
    }
    

    /**
     * Gets the products of the user
     * 
     * @param nickname the nickname of the user to search for the products
     * @return the list of products of the user
     */
    public List<Product> getProductsByUser(String nickname) {
        //TODO
        return null;
    }

    /**
     * gets all the users signed in the application
     * 
     * @return the list of users
     */
    public List<User> getAllUsers() {
        //TODO
        return null;
    }

    /**
     * Modifies the user in the database
     * 
     * @param nickname the new nickname of the user
     * @param password the new password of the user
     * @param firstname the new firstname of the user
     * @param lastname the new lastname of the user
     * @param email the new email of the user
     * @param dob the new date of birth of the user
     * 
     * @return the {@code User} with the newly modified properties
     */
    public User modifyUser(String nickname, String password, String firstname, String lastname, String email, Date dob) {
        //TODO
        return null;
    }

    /**
     * Deletes one user from the database
     * 
     * @param nickname the nickname of the user to delete
     * @return the {@code User} that has been deleted
     */
    public User deleteUser(String nickname) {
        //TODO
        return null;
    }
    
}
