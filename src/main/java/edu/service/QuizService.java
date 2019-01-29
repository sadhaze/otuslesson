package edu.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class QuizService implements QuizImpl{
    private AnswerCounter counter;
    private CsvQuestionReaderImpl questionReader;
    private Scanner scanner;

    public QuizService(AnswerCounter counter, CsvQuestionReaderImpl questionReader){
        this.counter = counter;
        this.questionReader = questionReader;
    }

    public void startQuiz(){
        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }
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
