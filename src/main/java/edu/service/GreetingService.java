package edu.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class GreetingService implements GreetingImpl{

    public String getGreeting(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String fname = in.nextLine();
        System.out.print("Введите свою фамилию: ");
        String lname = in.nextLine();
        return ("Здравствуйте, " + lname + " " + fname + "!");
    }
}
