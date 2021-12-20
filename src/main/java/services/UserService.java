package services;

import dao.UserDao;
import dao.UserDaoImpl;
import models.Login;
import models.User;

import java.util.List;

public class UserService {

    UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getOneUser(Integer userId){
        return userDao.getOneUser(userId);
    }

    public Boolean createUser(User user) {
        if (user.getFirstName() == null ) {
            return false;
        }
        userDao.createUser(user);
        return true;

    }

    public User updateUser (User updatedUser) {
        return userDao.updateUser(updatedUser);
    }

    public void deleteUser (Integer userId){
        userDao.deleteUser(userId);
    }


    public Login loginUser(String username, String password) {

//        if ()

        System.out.println(userDao.loginUser(username,password) + "service");
         return userDao.loginUser(username,password);

    }
}
