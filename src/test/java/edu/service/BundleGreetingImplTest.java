package edu.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Тест приветствия")
class BundleGreetingImplTest {
/*    @Mock
    private LocaleController bundleLocale;*/
    @Spy
    private MessageSource messageSource;

    private GreetingController greetingController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        //greetingController = new greetingController(bundleLocale, messageSource);
        //messageSource = Mockito.spy(MessageSource.class);
    }

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_1(){
       //when(messageSource.getMessage("greeting.hello", new String[] {"Яфамилия", "Яимя"}, new Locale("ru", "RU"))).thenReturn("dffff");
        //when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class))).thenReturn("dffff");
        //Mockito.doReturn("Здравствуйте, Яфамилия Яимя!").when(messageSource.getMessage("greeting.hello", new String[] {"Яфамилия", "Яимя"}, new Locale("ru", "RU")));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
       // Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", greetingController.getGreeting());
    }

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_2(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
       // Assertions.assertEquals("Hello, Яфамилия Яимя!", greetingController.getGreeting());
    }
}
