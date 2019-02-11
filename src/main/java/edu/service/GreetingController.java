package edu.service;

import edu.configs.AppConfig;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Service
@RestController
public class GreetingController {
    private BundleLocale bundleLocale = null;
    private MessageSource messageSource = null;

    public GreetingController(BundleLocale bundleLocale, AppConfig props){
        this.bundleLocale = bundleLocale;
        this.messageSource = props.getMessage();
        bundleLocale.setLocale(new Locale("en", "EN"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{lname}/{fname}")
    @ResponseBody
    public String getGreeting(@PathVariable("lname") String lname, @PathVariable("fname") String fname){
        return messageSource.getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                bundleLocale.getLocale());
    }
}
