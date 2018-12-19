package edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    AnswerCounterTest answerCounterTest(){
        return new AnswerCounterTest();
    }

    @Bean
    GreetingTest greetingTest(){
        return new GreetingTest();
    }

    @Bean
    QuizTest quizTest(){
        return new QuizTest();
    }
}
