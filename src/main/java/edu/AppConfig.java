package edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;

@Configuration
public class AppConfig {

    @Bean
    Auth auth(){
        return new Auth();
    }

    @Bean
    Greeting greeting(){
        return new Greeting();
    }

    @Bean
    Quiz quiz(){
        return new Quiz();
    }

    @Bean
    AnswerCounter answerCounter(){
        return new AnswerCounter();
    }
}
