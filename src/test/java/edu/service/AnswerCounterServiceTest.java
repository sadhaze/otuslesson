package edu.service;

import edu.service.AnswerCounterImpl;
import edu.service.AnswerCounterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест счетчика ответов")
class AnswerCounterServiceTest {
    private AnswerCounterImpl answerCounterService = new AnswerCounterService();

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
