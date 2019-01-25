package edu.config;

import edu.service.*;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppConfig {

/*    @Bean
    CsvQuestionReaderImpl questionReader() {
        return new CsvQuestionReaderDao("questions.csv");
    }*/

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/messages/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

/*    @Bean
    AnswerCounterImpl answerCounter(){
        return new AnswerCounter();
    }

    @Bean
    Greeting greeting(){
        return new Greeting();
    }

    @Bean
    Quiz quiz(AnswerCounterImpl counter){
        return new Quiz(counter);
    }*/
}
