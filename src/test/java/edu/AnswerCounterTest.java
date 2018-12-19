package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест счетчика ответов")
class AnswerCounterTest {
    private AnswerCounter answerCounter = new AnswerCounter();

    @Test
    @DisplayName("Тест счетчика ответов")
    void tAuthSuccessTest_1() {
        answerCounter.setRight();
        answerCounter.setWrong();
        answerCounter.setRight();
        answerCounter.setWrong();
        answerCounter.setRight();

        Assertions.assertEquals("\nВаш результат: 3 правильных ответа и 2 неправильных. Поздравляю!", answerCounter.getResult());
    }
}
