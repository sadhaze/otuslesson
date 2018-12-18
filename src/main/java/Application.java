import edu.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        //Auth auth = ctx.getBean(Auth.class);
        //auth.getAuth("Admin", "Admin");

        Greeting greeting = ctx.getBean(Greeting.class);
        Quiz quiz = ctx.getBean(Quiz.class);
        AnswerCounter answerCounter = ctx.getBean(AnswerCounter.class);

        System.out.println(greeting.getGreeting());

        for(int i = 1; i <= 5; i++) {
            answerCounter.setCount(quiz.getQuestion(i));
        }

        System.out.print(answerCounter.getResult());
    }
}