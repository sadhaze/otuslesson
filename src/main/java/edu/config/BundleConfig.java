package edu.config;

import edu.service.BundleGreetingService;
import edu.service.CsvQuestionReaderDao;
import edu.service.CsvQuestionReaderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BundleConfig {

    @Bean
    BundleGreetingService bundleGreetingService(){
        return new BundleGreetingService();
    }

    @Bean
    CsvQuestionReaderImpl bundleQuestionReader() {
        return new CsvQuestionReaderDao("bundleQuestions.csv");
    }
}
