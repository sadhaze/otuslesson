package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

@DisplayName("Тест приветствия")
class GreetingImplTest {
    private Greeting greetingService = new GreetingImpl();

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_1(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", greetingService.getGreeting());
    }
}
