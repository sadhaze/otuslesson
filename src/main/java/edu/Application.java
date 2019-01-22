package edu;

import edu.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
//@RestController
//@SpringBootApplication
//@EnableConfigurationProperties(YamlProps.class)
public class Application {

    //@RequestMapping("/")
    String home() {
        return "Hello Quiz!";
    }

    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

        //SpringApplication.run(Application.class, args);

        GreetingImpl greetingService = ctx.getBean(GreetingService.class);
        QuizImpl quizService = ctx.getBean(QuizService.class);
        AnswerCounterImpl answerCounter = ctx.getBean(AnswerCounterService.class);
        CsvQuestionReaderImpl fileReader = ctx.getBean(CsvQuestionReaderDao.class);

        //System.out.println(greetingService.getGreeting());
        //quizService.startQuiz();
        //System.out.print(answerCounter.getResult());

        GreetingImpl bundleGreetingService = ctx.getBean(BundleGreetingService.class);
        QuizImpl bundleQuizService = ctx.getBean(BundleQuizService.class);

        System.out.println(bundleGreetingService.getGreeting());
        bundleQuizService.startQuiz();
        System.out.print(answerCounter.getResult());
    }
}