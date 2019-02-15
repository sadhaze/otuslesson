package edu.service;

import edu.configs.YAMLConfig;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Scanner;

//@RestController
@Service
public class QuizController{
    private AnswerCounterController counter;
    private CsvQuestionReaderDao questionReader;
    private GreetingController greetingController;
    private MessageSource messageSource;
    private YAMLConfig props;

    private Scanner scanner;

    public QuizController(AnswerCounterController counter, CsvQuestionReaderDao questionReader, GreetingController greetingController, YAMLConfig props){
        this.counter = counter;
        this.questionReader = questionReader;
        this.greetingController = greetingController;
        this.props = props;
        this.props.setLocale();
        this.props.setMessageSource();
        this.messageSource = this.props.getMessageSource();
        questionReader.readFile(
                messageSource.getMessage(
                        "quiz.datafile.name",
                        new String[] {""},
                        props.getLocale()));
        System.out.println(this.getQuiz("Ant", "Lit"));
    }

/*    @RequestMapping(method = RequestMethod.GET, value = "/quiz")
    @ResponseBody
    public String getQuiz(@RequestParam(name="lname") String lname, @RequestParam(name="fname") String fname, YAMLConfig props){*/
    public String getQuiz(String lname, String fname){
        counter.clearCounter();

        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            System.out.println(this.getQuestion(i));
        }

        return greetingController.getGreeting(lname, fname) + "<br>" + counter.getResult();
    }

    public String getQuestion(int questionNumber) {
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
