package edu.service;

import edu.configs.AppConfig;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
/*    private MessageSource messageSource = null;

    public GreetingController(AppConfig props){
        this.messageSource = props.getMessage();
    }*/

    //http://localhost:8080/greeting?lname=Lit&fname=Ant --Example
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    @ResponseBody
    public String getGreeting(@RequestParam(name="lname") String lname, @RequestParam(name="fname") String fname, AppConfig props){
        return props.getMessageSource().getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                props.getLocale());
    }
}
