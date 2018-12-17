package edu;

import java.util.Scanner;

public class Greeting {

    public String getGreeting(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String fname = in.nextLine();
        System.out.print("Введите свою фамилию: ");
        String lname = in.nextLine();
        return ("Здравствуйте, " + lname + " " + fname + "!");
    }
}
