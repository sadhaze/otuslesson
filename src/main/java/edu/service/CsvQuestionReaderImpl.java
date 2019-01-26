package edu.service;

public interface CsvQuestionReaderImpl {
    String getAnswer(int lineNumber);
    String getQuestion(int lineNumber);
    void readFile(String fileName);
    int questionValidation(int questionNumber);
}
