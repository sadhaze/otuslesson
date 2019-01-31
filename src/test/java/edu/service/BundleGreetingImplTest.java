package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@DisplayName("Тест приветствия")
class BundleGreetingImplTest {
/*    @Mock
    private BundleLocale locale = new BundleLocaleImpl();

    @Mock
    private MessageSource messageSource = new MessageSource();

    @Mock
    private Greeting bundleGreetingService = new GreetingBundleImpl(locale, messageSource);

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_1(){
        locale.setLocale(new Locale("ru", "RU"));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Здравствуйте, Яфамилия Яимя!", bundleGreetingService.getGreeting());
    }

    @Test
    @DisplayName("Тест приветствия")
    void tGreetingTest_2(){
        locale.setLocale(new Locale("en", "EN"));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Hello, Яфамилия Яимя!", bundleGreetingService.getGreeting());
    }*/
}
