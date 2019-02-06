package edu;

import edu.configs.YamlProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
//@ComponentScan
@RestController
@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
//@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    String home() {
        return "Hello Quiz!!!";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
    }
}