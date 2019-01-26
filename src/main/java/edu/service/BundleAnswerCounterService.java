package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class BundleAnswerCounterService implements AnswerCounterImpl {

    @Autowired
    private MessageSource messageSource;
    private BundleLocaleImpl bundleLocale;

    private Integer right = 0;
    private Integer wrong = 0;

    public BundleAnswerCounterService(BundleLocaleImpl bundleLocale){
        this.bundleLocale = bundleLocale;
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
