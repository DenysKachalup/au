package service;

import entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(long id);
    boolean updateUser(User user);
    boolean saveUser(User user);
    void deleteUser(User user);
}
