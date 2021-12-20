package services;

import dao.UserDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceTest {

    UserDao userDao = Mockito.mock(UserDao.class);
    UserService userService;

    @Test
    void getAllUsers() {
    }

    @Test
    void getOneUser() {
//        User user = new User(1,"Paul","PIKE", "Law", "Limit", "ll@004",1);
//        Mockito.when(userDao.getOneUser(1)).thenReturn(user) ;
//
//        User expectedValue = user;
//
//        User actualResult = userService.getOneUser(1);
//        assertEquals(actualResult, expectedValue);

    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void loginUser() {
    }
}