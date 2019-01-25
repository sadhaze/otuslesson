package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class BundleGreetingService implements GreetingImpl {

    @Autowired
    private MessageSource messageSource;

    public String getGreeting(){
        Scanner in = new Scanner(System.in);

        System.out.println(
                messageSource.getMessage(
                        "greeting.fname",
                        new String[] {" "},
                        Locale.ENGLISH)
        );

        String fname = in.nextLine();

        System.out.println(
                messageSource.getMessage(
                        "greeting.lname",
                        new String[] {" "},
                        Locale.ENGLISH)
        );

        String lname = in.nextLine();

        return messageSource.getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                Locale.ENGLISH);
    }
}
