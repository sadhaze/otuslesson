package edu.service;

import edu.configs.AppConfig;
import org.springframework.stereotype.Service;

@Service("Answer counter bundle service")
public class AnswerCounterController {
    private Integer right = 0;
    private Integer wrong = 0;

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

    public void clearCounter(){
        this.right = 0;
        this.wrong = 0;
    }
}
