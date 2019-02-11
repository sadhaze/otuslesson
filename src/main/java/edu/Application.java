package edu;

import edu.configs.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
//@ComponentScan
@RestController
@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
//@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
    }
}