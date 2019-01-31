package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

@DisplayName("Тест викторины")
class QuizImplTest {
    @Mock
    private AnswerCounterImpl counter;

    @Mock
    private CsvQuestionReaderDaoImpl fileReader;

    @Mock
    private GreetingImpl greetingImpl;

    @Mock
    private Quiz quizService = new QuizImpl(counter, fileReader, greetingImpl);

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
        Assertions.assertEquals("Не верный ответ! В свледующий раз повезет!\n", quizService.getQuestion(0));
    }

    @Disabled
    @Test
    @DisplayName("Тест на некорректный ответ")
    void tAuthSuccessTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("Бинго!\n", quizService.getQuestion(4));
    }
}
