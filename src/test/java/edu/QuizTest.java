package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class QuizTest {
    private Quiz quiz = new Quiz();

    @Test
    void tAuthNoQuestionTest_1() {
        Assertions.assertEquals("\nВопрос с указанным номером отсутствует!", quiz.getQuestion(0));
    }

    @Test
    void tAuthNoQuestionTest_2() {
        Assertions.assertEquals("\nВопрос с указанным номером отсутствует!", quiz.getQuestion(6));
    }

    @Test
    void tAuthFailedTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("Не верный ответ! В свледующий раз повезет!", quiz.getQuestion(1));
    }

    @Test
    void tAuthSuccessTest_1() {
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("Бинго!\n", quiz.getQuestion(5));
    }
}
