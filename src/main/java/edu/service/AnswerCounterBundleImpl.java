package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("Answer counter bundle service")
public class AnswerCounterBundleImpl implements AnswerCounter {
    private BundleLocale bundleLocale = null;
    private MessageSource messageSource = null;

    private Integer right = 0;
    private Integer wrong = 0;

    @Autowired
    public AnswerCounterBundleImpl(BundleLocale bundleLocale, MessageSource messageSource){
        this.bundleLocale = bundleLocale;
        this.messageSource = messageSource;
    }

    public void setRight(){
        right++;
    }

    public void setWrong(){
        wrong++;
    }

    public String getResult(){

        return messageSource.getMessage(
                "counter.result",
                new String[] {right.toString(), wrong.toString()},
                bundleLocale.getLocale());
    }
}
