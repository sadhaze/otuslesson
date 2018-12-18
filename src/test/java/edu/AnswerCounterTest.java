package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnswerCounterTest {
    private AnswerCounter answerCounter = new AnswerCounter();

    @Test
    void tAuthSuccessTest_1() {
        answerCounter.setCount("Бинго!\n");
        answerCounter.setCount("Упс!");
        answerCounter.setCount("Бинго!\n");
        answerCounter.setCount("Пупс!");
        answerCounter.setCount("Бинго!\n");

        Assertions.assertEquals("\nВаш результат: 3 правильных ответа и 2 неправильных. Поздравляю!", answerCounter.getResult());
    }
}
