package edu;

import edu.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

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

        //Обычная викторина ----------------------------------------------
        Greeting greetingImpl = ctx.getBean(GreetingImpl.class);
        Quiz quizImpl = ctx.getBean(QuizImpl.class);
        AnswerCounter answerCounterImpl = ctx.getBean(AnswerCounterImpl.class);
        CsvQuestionReaderDao fileReader = ctx.getBean(CsvQuestionReaderDaoImpl.class);

        quizImpl.startQuiz();

        //Бандл викторина ------------------------------------------------
        BundleLocale bundleLocaleImpl = ctx.getBean(BundleLocaleImpl.class);
        Greeting greetingBundleImpl = ctx.getBean(GreetingBundleImpl.class);
        Quiz quizBundleImpl = ctx.getBean(QuizBundleImpl.class);
        AnswerCounter answerCounterBundleImpl = ctx.getBean(AnswerCounterBundleImpl.class);

        quizBundleImpl.startQuiz();
    }
}