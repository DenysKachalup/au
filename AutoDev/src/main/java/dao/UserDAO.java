package dao;

import entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();
    User getUserById(long id);
    boolean updateUser(User user);
    boolean saveUser(User user);
    void deleteUser(User user);

}
