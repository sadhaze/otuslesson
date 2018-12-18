package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class GreetingTest {
    private Greeting greeting = new Greeting();

    @Test
    void tGreetingTest_1(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", greeting.getGreeting());
    }
}
