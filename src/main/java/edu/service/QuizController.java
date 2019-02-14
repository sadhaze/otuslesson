package edu.service;

import edu.configs.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Scanner;

@RestController
public class QuizController{
    private AnswerCounterController counter;
    private CsvQuestionReaderDao questionReader;
    private GreetingController greetingController;
    private MessageSource messageSource;

    private Scanner scanner;

    public QuizController(AnswerCounterController counter, CsvQuestionReaderDao questionReader, GreetingController greetingController, AppConfig props){
        this.counter = counter;
        this.questionReader = questionReader;
        this.greetingController = greetingController;
        this.messageSource = props.getMessageSource();
        questionReader.readFile(
                messageSource.getMessage(
                        "quiz.datafile.name",
                        new String[] {""},
                        props.getLocale())
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = "/quiz")
    @ResponseBody
    public String getQuiz(@RequestParam(name="lname") String lname, @RequestParam(name="fname") String fname, AppConfig props){
        counter.clearCounter();

        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i, props);
        }

        return greetingController.getGreeting(lname, fname, props) + "<br>" + counter.getResult(props);
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
