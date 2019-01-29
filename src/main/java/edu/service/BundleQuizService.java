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

    private AnswerCounter counter;
    private CsvQuestionReaderImpl questionReader;
    private Scanner scanner;

    public BundleQuizService(AnswerCounter counter, CsvQuestionReaderImpl questionReader){
        this.counter = counter;
        this.questionReader = questionReader;
    }

    public void startQuiz(){
        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }
    }

    public String getQuestion(int questionNumber) {
        if(questionReader.questionValidation(questionNumber) == -1) {
            return messageSource.getMessage(
                    "quiz.noquestion",
                    new String[] {""},
                    Locale.ENGLISH);
        }

        System.out.print("\n" + questionReader.getQuestion(questionNumber) + "\n" + messageSource.getMessage(
                "quiz.answer",
                new String[] {""},
                Locale.ENGLISH)
        );
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(questionReader.getAnswer(questionNumber)) != 0){
            counter.setWrong();
            return messageSource.getMessage(
                    "quiz.wrong",
                    new String[] {"\n"},
                    Locale.ENGLISH);
        } else {
            counter.setRight();
            return messageSource.getMessage(
                    "quiz.right",
                    new String[] {"\n"},
                    Locale.ENGLISH);
        }
        //return "Что-то пошло не так!";
    }
}
