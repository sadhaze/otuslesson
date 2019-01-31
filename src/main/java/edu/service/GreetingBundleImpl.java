package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("Greeting bundle service")
public class GreetingBundleImpl implements Greeting {
    private BundleLocale bundleLocale = null;
    private MessageSource messageSource = null;

    @Autowired
    public GreetingBundleImpl(BundleLocale bundleLocale, MessageSource messageSource){
        this.bundleLocale = bundleLocale;
        this.messageSource = messageSource;
    }

    public String getGreeting(){
        Scanner in = new Scanner(System.in);

        System.out.println(
                messageSource.getMessage(
                        "greeting.fname",
                        new String[] {""},
                        bundleLocale.getLocale())
        );

        String fname = in.nextLine();

        System.out.println(
                messageSource.getMessage(
                        "greeting.lname",
                        new String[] {""},
                        bundleLocale.getLocale())
        );

        String lname = in.nextLine();

        return messageSource.getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                bundleLocale.getLocale());
    }
}
