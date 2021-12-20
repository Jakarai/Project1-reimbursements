package dao;

import models.Login;
import models.User;

import java.util.List;

public interface UserDao {


    Login loginUser(String username, String password);
    List<User> getAllUsers();
    User getOneUser(Integer userId);
    void createUser(User user);
    User updateUser(User user);
    void deleteUser(Integer user);

}
