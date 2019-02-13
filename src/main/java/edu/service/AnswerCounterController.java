package edu.service;

import edu.configs.AppConfig;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Service("Answer counter bundle service")
//@RestController
public class AnswerCounterController {
    //private LocaleController bundleLocale = null;
    //private MessageSource messageSource = null;

    private Integer right = 0;
    private Integer wrong = 0;

    //@Autowired
/*
    public AnswerCounterController(AppConfig props){
        this.bundleLocale = props.getLocaleController();
        this.messageSource = props.getMessage();
        //bundleLocale.setLocale(new Locale("en", "EN"));
    }
*/

    public void setRight(){
        right++;
    }

    public void setWrong(){
        wrong++;
    }

    public String getResult(AppConfig props){

        return props.getMessageSource().getMessage(
                "counter.result",
                new String[] {right.toString(), wrong.toString()},
                props.getLocale());
    }
}
