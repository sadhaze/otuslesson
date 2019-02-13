package edu.service;

import edu.configs.AppConfig;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Service
@RestController
public class GreetingController {
/*    private MessageSource messageSource = null;

    public GreetingController(AppConfig props){
        this.messageSource = props.getMessage();
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{lname}/{fname}")
    @ResponseBody
    public String getGreeting(@PathVariable("lname") String lname, @PathVariable("fname") String fname, AppConfig props){
        return props.getMessageSource().getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                props.getLocale());
    }
}
