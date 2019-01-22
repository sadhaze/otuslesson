package edu.service;

import edu.service.GreetingImpl;
import edu.service.GreetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

@DisplayName("Тест приветствия")
class GreetingServiceTest {
    private GreetingImpl greetingService = new GreetingService();

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_1(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", greetingService.getGreeting());
    }
}
