package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class BundleQuizService implements QuizImpl {

    @Autowired
    private MessageSource messageSource;
    private BundleLocaleImpl bundleLocale;

    private AnswerCounterImpl counter;
    private CsvQuestionReaderImpl questionReader;
    private Scanner scanner;

    public BundleQuizService(BundleAnswerCounterService counter, CsvQuestionReaderImpl questionReader, BundleLocaleImpl bundleLocale){
        this.counter = counter;
        this.questionReader = questionReader;
        this.bundleLocale = bundleLocale;
    }

    public void startQuiz(){
        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            System.out.println(this.getQuestion(i));
        }
    }

    public String getQuestion(int questionNumber) {
        if(questionReader.questionValidation(questionNumber) == -1) {
            return messageSource.getMessage(
                    "quiz.noquestion",
                    new String[] {""},
                    bundleLocale.getLocale());
        }

        System.out.print("\n"
                +
                messageSource.getMessage(
                        questionReader.getQuestion(questionNumber),
                        new String[] {""},
                        bundleLocale.getLocale())
                +
                "\n"
                +
                messageSource.getMessage(
                        "quiz.answer",
                        new String[] {""},
                        bundleLocale.getLocale())
        );
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(
                messageSource.getMessage(
                        questionReader.getAnswer(questionNumber),
                        new String[] {""},
                        bundleLocale.getLocale())
                ) != 0){
            counter.setWrong();
            return messageSource.getMessage(
                    "quiz.wrong",
                    new String[] {""},
                    bundleLocale.getLocale());
        } else {
            counter.setRight();
            return messageSource.getMessage(
                    "quiz.right",
                    new String[] {""},
                    bundleLocale.getLocale());
        }
        //return "Что-то пошло не так!";
    }
}
