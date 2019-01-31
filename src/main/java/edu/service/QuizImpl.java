package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("Quiz service")
public class QuizImpl implements Quiz {
    private AnswerCounterImpl counter = null;
    private CsvQuestionReaderDaoImpl questionReader = null;
    private GreetingImpl greetingImpl = null;

    private Scanner scanner;

    @Autowired
    public QuizImpl(AnswerCounterImpl counter, CsvQuestionReaderDaoImpl questionReader, GreetingImpl greetingImpl){
        this.counter = counter;
        this.questionReader = questionReader;
        this.greetingImpl = greetingImpl;
    }

    public void startQuiz(){
        questionReader.readFile("questions.csv");

        System.out.println("\n" + greetingImpl.getGreeting());

        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }

        System.out.print(counter.getResult() + "\n");
    }

    public String getQuestion(int questionNumber) {
        if(questionReader.questionValidation(questionNumber) == -1) return "\nВопрос с указанным номером отсутствует!";

        System.out.print("\n" + questionReader.getQuestion(questionNumber) + "\nВведите ответ буквами: ");
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(questionReader.getAnswer(questionNumber)) != 0){
            counter.setWrong();
            return "Не верный ответ! В свледующий раз повезет!\n";
        } else {
            counter.setRight();
            return "Бинго!\n";
        }
        //return "Что-то пошло не так!";
    }
}
