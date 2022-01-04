package Persist;

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

    void updateUser(User u);
}
