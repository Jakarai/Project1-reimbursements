package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import models.JsonResponse;
import models.Login;
import models.User;
import org.apache.log4j.Logger;
import services.UserService;

public class UserController {
    static UserService userService = new UserService();
    Logger logger = Logger.getLogger(UserController.class);

    public void getAllUsers(Context context) throws JsonProcessingException {
        context.contentType("application/json");

    }

    public void getOneUser(Context context) throws JsonProcessingException{
        context.contentType("application/json");

        Integer userId = Integer.parseInt(context.pathParam("userId"));

        User user = userService.getOneUser(userId);

        context.result(new ObjectMapper().writeValueAsString(user));

    }

    public void createUser (Context context) throws JsonProcessingException {
        User user = context.bodyAsClass(User.class);

        if (userService.createUser(user)) {
            String jsonString = new ObjectMapper().writeValueAsString(user);
            context.result(jsonString);
        }else {
            context.result("sorry user was not created");
        }

    }

    public void updateUser(Context context) throws JsonProcessingException {
        Integer userId = Integer.parseInt(context.pathParam("userId"));
//        String firstName = context.formParam("");
        User user = context.bodyAsClass(User.class);

        context.contentType("application/json");
        User updatedUser = userService.updateUser(user);
        String jsonString = new ObjectMapper().writeValueAsString(user);
        context.result(jsonString);
    }

    public void loginUser(Context context) throws JsonProcessingException {
        context.contentType("application/json");


        Login userLogin = context.bodyAsClass(Login.class);
        Login checkLogin = userService.loginUser(userLogin.getUsername(),userLogin.getPassword());


//        String username = context.formParam("username");
//        String password = context.formParam("password");

        System.out.println(checkLogin + "controller");
//        userService.loginUser(userLogin.getUsername(),userLogin.getPassword());
        System.out.println(userLogin.getPassword() + "C2");
        System.out.println(checkLogin.getPassword() +"C3");
        System.out.println(checkLogin.getUsername() != null );


        try {


        if (checkLogin.getUsername() != null) {

            System.out.println("you did it");
            context.sessionAttribute("user", checkLogin.getUserId());
            context.result("success");
        } else {
            context.status(404);
            context.result("No account Found");
        }
        }
        catch (Exception e) {

            logger.error(e);

        }

        context.sessionAttribute("username", checkLogin.getUsername());
        context.sessionAttribute("role", checkLogin.getRoleId());
        context.sessionAttribute("user", checkLogin.getUserId());

        System.out.println(context.sessionAttributeMap());
        System.out.println(userLogin + "controller 2");
        context.json(checkLogin);
//        context.json(new ObjectMapper().writeValueAsString(userLogin));
    }

    public void checkSession(Context context) {
        User user = context.sessionAttribute("user-session");


        if (user == null) {
            context.json(new JsonResponse(false, "no session found", (Object)null));
        } else {
            context.json(new JsonResponse(true, "session found", new User(user.getUsername(), user.getRoleId(), user.getUserId())));
        }

    }
}
