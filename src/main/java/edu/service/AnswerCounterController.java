package edu.service;

import edu.configs.YAMLConfig;
import org.springframework.stereotype.Service;

@Service("Answer counter bundle service")
public class AnswerCounterController {
    private Integer right = 0;
    private Integer wrong = 0;
    private YAMLConfig props;

    public AnswerCounterController(YAMLConfig props){
        this.props = props;
    }

    public void setRight(){
        right++;
    }

    public void setWrong(){
        wrong++;
    }

    public String getResult(){
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
