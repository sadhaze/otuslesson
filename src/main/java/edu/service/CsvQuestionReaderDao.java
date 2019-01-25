package edu.service;

import java.io.*;
import java.util.ArrayList;

public class CsvQuestionReaderDao implements CsvQuestionReaderImpl {
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();

    public CsvQuestionReaderDao(String fileName) {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            String[] string = {"", ""};

            line = bufferedReader.readLine();
            for (int i = 0; line.length() != 0; i++) {
                string = line.split("\\|");
                this.questions.add(i, string[0]);
                this.answers.add(i, string[1]);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getAnswer(int answerNumber) {
        if(answerNumber < 0 || answerNumber > this.answers.size()) {
            return null;
        } else {
            return this.answers.get(answerNumber);
        }
    }

    public String getQuestion(int questionNumber) {
        if(questionNumber < 0 || questionNumber >= this.questions.size()) {
            return null;
        } else {
            return this.questions.get(questionNumber);
        }
    }

    public int questionValidation(int questionNumber){
        if(questionNumber < 0 || questionNumber >= this.answers.size()) {
            return -1;
        } else {
            return this.questions.size();
        }
    }
}