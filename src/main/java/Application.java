import edu.AppConfig;
import edu.Auth;
import edu.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        //Auth auth = ctx.getBean(Auth.class);
        User user = ctx.getBean(User.class);

        System.out.println(user.getClass());
        user.getUser("Admin");
    }
}