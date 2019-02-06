package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.ByteArrayInputStream;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Тест приветствия")
class BundleGreetingImplTest {
    @Mock
    private BundleLocale bundleLocale;
    @Spy
    private MessageSource messageSource;

    private Greeting bundleGreetingService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        bundleGreetingService = new GreetingBundleImpl(bundleLocale, messageSource);
        //messageSource = Mockito.spy(MessageSource.class);
    }

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_1(){
       //when(messageSource.getMessage("greeting.hello", new String[] {"Яфамилия", "Яимя"}, new Locale("ru", "RU"))).thenReturn("dffff");
        //when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class))).thenReturn("dffff");
        //Mockito.doReturn("Здравствуйте, Яфамилия Яимя!").when(messageSource.getMessage("greeting.hello", new String[] {"Яфамилия", "Яимя"}, new Locale("ru", "RU")));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", bundleGreetingService.getGreeting());
    }

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_2(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Hello, Яфамилия Яимя!", bundleGreetingService.getGreeting());
    }
}
