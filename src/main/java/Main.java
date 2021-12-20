import frontcontrollers.FrontController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {


   static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.setLevel(Level.DEBUG);

        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.addStaticFiles("/frontend", Location.CLASSPATH);
        }).start(9000);

        new FrontController(app);


    }
}
