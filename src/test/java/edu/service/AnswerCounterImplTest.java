package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест счетчика ответов")
class AnswerCounterImplTest {
    private AnswerCounter answerCounterService = new AnswerCounterImpl();

    @Test
    @DisplayName("Тест счетчика ответов")
    void tAuthSuccessTest_1() {
        answerCounterService.setRight();
        answerCounterService.setWrong();
        answerCounterService.setRight();
        answerCounterService.setWrong();
        answerCounterService.setRight();

        Assertions.assertEquals("\nВаш результат: 3 правильных ответа и 2 неправильных. Поздравляю!", answerCounterService.getResult());
    }
}
