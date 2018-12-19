package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

@DisplayName("Тест викторины")
class QuizTest {
    @Mock
    private IAnswerCounter counter = new AnswerCounter();

    private Quiz quiz = new Quiz(counter);

    @Test
    @DisplayName("Тест когда номер вопроса меньше меньше или равен нулю")
    void tAuthNoQuestionTest_1() {
        Assertions.assertEquals("\nВопрос с указанным номером отсутствует!", quiz.getQuestion(0));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше больше пяти")
    void tAuthNoQuestionTest_2() {
        Assertions.assertEquals("\nВопрос с указанным номером отсутствует!", quiz.getQuestion(6));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void tAuthFailedTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("Не верный ответ! В свледующий раз повезет!\n", quiz.getQuestion(1));
    }

    @Disabled
    @Test
    @DisplayName("Тест на некорректный ответ")
    void tAuthSuccessTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("Бинго!\n", quiz.getQuestion(5));
    }
}
