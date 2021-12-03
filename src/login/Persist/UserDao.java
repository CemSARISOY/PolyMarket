package Persist;

import Core.User;

public interface UserDao {
    
    User getUserById(int id);
    User getUserByNickname(String nickname);
}
