package edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Auth auth(){
        return new Auth();
    }

    @Bean
    User user(){
        return new User();
    }
}
