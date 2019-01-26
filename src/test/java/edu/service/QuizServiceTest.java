package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

@DisplayName("Тест викторины")
class QuizServiceTest {
    @Mock
    private AnswerCounterService counter = new AnswerCounterService();

    @Mock
    private CsvQuestionReaderDao fileReader = new CsvQuestionReaderDao("questions.csv");

    private QuizImpl quizService = new QuizService(counter, fileReader);

    @Test
    @DisplayName("Тест когда номер вопроса меньше меньше или равен нулю")
    void tAuthNoQuestionTest_1() {
        Assertions.assertEquals("\nВопрос с указанным номером отсутствует!", quizService.getQuestion(-1));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше больше пяти")
    void tAuthNoQuestionTest_2() {
        Assertions.assertEquals("\nВопрос с указанным номером отсутствует!", quizService.getQuestion(5));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void tAuthFailedTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("Не правильный ответ! В другой раз повезет!", quizService.getQuestion(0));
    }

    @Disabled
    @Test
    @DisplayName("Тест на некорректный ответ")
    void tAuthSuccessTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ".getBytes()));
        Assertions.assertEquals("Бинго!", quizService.getQuestion(4));
    }
}
