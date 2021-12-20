package frontcontrollers;

import controllers.ReimbursementController;
import controllers.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {

    UserController userController = new UserController();
    ReimbursementController reimbursementController = new ReimbursementController();

    public Dispatcher(Javalin app) {

        app.routes(() -> {
            path("/api/login", () -> {
                post(userController::loginUser);
            });
            path("/check-session", () -> {
                get(userController::checkSession);
            });
            path("/users", () ->{
                post(userController::createUser);
                path("/{userId}", ()-> {
                    get(userController::getOneUser);
                    patch(userController::updateUser);
                    path("/reimbursementsAdmin", ()->{
                        get(reimbursementController::getAllReimbsAdmin);
                    });
                    path("/reimbursements",()->{
                        get(reimbursementController::getAllReimbs);
                        post(reimbursementController::createReimb);
                        path("/{reimbId}", ()-> {
                            get(reimbursementController::getOneReimb);
                            patch(reimbursementController::updateOneReimb);
                        });
                    });
                });
            });
        });

    }
}
