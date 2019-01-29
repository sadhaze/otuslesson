package edu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    AnswerCounterServiceTest answerCounterTest(){
        return new AnswerCounterServiceTest();
    }

    @Bean
    BundleGreetingServiceTest bundleGreetingTest(){
        return new BundleGreetingServiceTest();
    }

    @Bean
    GreetingServiceTest greetingTest(){
        return new GreetingServiceTest();
    }

    @Bean
    QuizServiceTest quizTest(){
        return new QuizServiceTest();
    }
}
