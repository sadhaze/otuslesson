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
        GreetingImpl greetingService = ctx.getBean(GreetingService.class);
        QuizImpl quizService = ctx.getBean(QuizService.class);
        AnswerCounter answerCounter = ctx.getBean(AnswerCounterService.class);
        CsvQuestionReaderImpl fileReader = ctx.getBean(CsvQuestionReaderDao.class);

                fileReader.readFile("questions.csv");
        System.out.println(greetingService.getGreeting());
        quizService.startQuiz();
        System.out.print(answerCounter.getResult());

        //Бандл викторина ------------------------------------------------
        GreetingImpl bundleGreetingService = ctx.getBean(BundleGreetingService.class);
        QuizImpl bundleQuizService = ctx.getBean(BundleQuizService.class);
        AnswerCounterImpl bundleAnswerCounter = ctx.getBean(BundleAnswerCounterService.class);
        BundleLocaleImpl bundleLocale = ctx.getBean(BundleLocaleService.class);
        bundleLocale.setLocale(new Locale("ru", "RU"));

        fileReader.readFile("bundleQuestions.csv");
        System.out.println(bundleGreetingService.getGreeting());
        bundleQuizService.startQuiz();
        System.out.print("\n" + bundleAnswerCounter.getResult() + "\n");
    }
}