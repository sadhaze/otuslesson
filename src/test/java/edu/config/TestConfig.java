package edu.service;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class TestConfig {
    @Bean
    AnswerCounterImplTest answerCounterImplTest(){
        return new AnswerCounterImplTest();
    }

/*    @Bean
    GreetingBundleImplTest greetingBundleImplTest(){
        return new GreetingBundleImplTest();
    }*/

    @Bean
    GreetingImplTest greetingImplTest(){
        return new GreetingImplTest();
    }

    @Bean
    QuizImplTest quizImplTest(){
        return new QuizImplTest();
    }
}
