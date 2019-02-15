package edu.service;

import edu.configs.YAMLConfig;
import org.springframework.stereotype.Service;

//@RestController
@Service
public class GreetingController {
    YAMLConfig props;

    private GreetingController(YAMLConfig props){
        this.props = props;
    }
    //http://localhost:8080/greeting?lname=Lit&fname=Ant --Example
/*    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    @ResponseBody
    public String getGreeting(@RequestParam(name="lname") String lname, @RequestParam(name="fname") String fname, YAMLConfig props){*/
    public String getGreeting(String lname, String fname){
        return props.getMessageSource().getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                props.getLocale());
    }
}
