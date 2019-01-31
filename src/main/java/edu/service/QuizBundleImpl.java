package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service("Quiz bundle service")
public class QuizBundleImpl implements Quiz {
    private AnswerCounterBundleImpl counter = null;
    private BundleLocale bundleLocale = null;
    private CsvQuestionReaderDaoImpl questionReader = null;
    private GreetingBundleImpl greetingBundleImpl = null;
    private MessageSource messageSource = null;

    private Scanner scanner;

    public QuizBundleImpl(AnswerCounterBundleImpl counter, BundleLocale bundleLocale, CsvQuestionReaderDaoImpl questionReader, GreetingBundleImpl greetingBundleImpl, MessageSource messageSource){
        this.counter = counter;
        this.bundleLocale = bundleLocale;
        this.questionReader = questionReader;
        this.greetingBundleImpl = greetingBundleImpl;
        this.messageSource = messageSource;
    }

    public void startQuiz(){
        bundleLocale.setLocale(new Locale("en", "EN"));

        questionReader.readFile(
                messageSource.getMessage(
                        "quiz.datafile.name",
                        new String[] {""},
                        bundleLocale.getLocale())
        );

        System.out.println("\n" + greetingBundleImpl.getGreeting());

        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }

        System.out.print("\n" + counter.getResult() + "\n");
    }

    public String getQuestion(int questionNumber) {
        if(questionReader.questionValidation(questionNumber) == -1) {
            return messageSource.getMessage(
                    "quiz.noquestion",
                    new String[] {""},
                    bundleLocale.getLocale());
        }

        System.out.print("\n" + questionReader.getQuestion(questionNumber) + "\n" + messageSource.getMessage(
                "quiz.answer",
                new String[] {""},
                bundleLocale.getLocale())
        );
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(questionReader.getAnswer(questionNumber)) != 0){
            counter.setWrong();
            return messageSource.getMessage(
                    "quiz.wrong",
                    new String[] {"\n"},
                    bundleLocale.getLocale());
        } else {
            counter.setRight();
            return messageSource.getMessage(
                    "quiz.right",
                    new String[] {"\n"},
                    bundleLocale.getLocale());
        }
        //return "Что-то пошло не так!";
    }
}