package edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@DisplayName("Тест приветствия")
class BundleGreetingServiceTest {
    private BundleLocaleImpl locale = new BundleLocaleService();
    private GreetingImpl bundleGreetingService = new BundleGreetingService(locale);

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
    }
}
