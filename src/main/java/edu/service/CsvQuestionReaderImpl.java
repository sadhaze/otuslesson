package edu.service;

public interface CsvQuestionReaderImpl {
    String getAnswer(int lineNumber);
    String getQuestion(int lineNumber);
    int questionValidation(int questionNumber);
}
