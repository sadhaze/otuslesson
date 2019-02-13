package edu.service;

import edu.configs.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Scanner;

@RestController
public class QuizController{
    private AnswerCounterController counter = null;
    //private LocaleController bundleLocale = null;
    private CsvQuestionReaderDao questionReader = null;
    private GreetingController greetingController = null;
    private MessageSource messageSource = null;

    private Scanner scanner;

    //@Autowired
    public QuizController(AnswerCounterController counter, CsvQuestionReaderDao questionReader, GreetingController greetingController, AppConfig props){
        this.counter = counter;
        //this.bundleLocale = props.getLocaleController();
        this.questionReader = questionReader;
        this.greetingController = greetingController;
        //this.messageSource = props.getMessage();
        //bundleLocale.setLocale(new Locale("en", "EN"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/quiz/{lname}/{fname}")
    @ResponseBody
    public void getQuiz(@PathVariable("lname") String lname, @PathVariable("fname") String fname, AppConfig props){
        questionReader.readFile(
                messageSource.getMessage(
                        "quiz.datafile.name",
                        new String[] {""},
                        props.getLocale())
        );

        //System.out.println("\n" + bundleLocale.getLocale());
        //System.out.println("\n" + greetingController.getGreeting(lname, fname));

        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i, props);
        }

        //System.out.print("\n" + counter.getResult() + "\n");
    }

    public String getQuestion(int questionNumber, AppConfig props) {
        if(questionReader.questionValidation(questionNumber) == -1) {
            return messageSource.getMessage(
                    "quiz.noquestion",
                    new String[] {""},
                    props.getLocale());
        }

        System.out.print("\n" + questionReader.getQuestion(questionNumber) + "\n" + messageSource.getMessage(
                "quiz.answer",
                new String[] {""},
                props.getLocale())
        );
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(questionReader.getAnswer(questionNumber)) != 0){
            counter.setWrong();
            return messageSource.getMessage(
                    "quiz.wrong",
                    new String[] {"\n"},
                    props.getLocale());
        } else {
            counter.setRight();
            return messageSource.getMessage(
                    "quiz.right",
                    new String[] {"\n"},
                    props.getLocale());
        }
        //return "Что-то пошло не так!";
    }
}
