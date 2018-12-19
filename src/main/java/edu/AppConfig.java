package edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    IAnswerCounter answerCounter(){
        return new AnswerCounter();
    }

    @Bean
    Greeting greeting(){
        return new Greeting();
    }

    @Bean
    Quiz quiz(IAnswerCounter counter){
        return new Quiz(counter);
    }
}
