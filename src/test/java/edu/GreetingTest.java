package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

@DisplayName("Тест приветствия")
class GreetingTest {
    private Greeting greeting = new Greeting();

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_1(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", greeting.getGreeting());
    }
}
