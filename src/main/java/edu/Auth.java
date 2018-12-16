package edu;

import java.io.BufferedReader;
import java.io.IOException;

public class Auth {

    public String getAuth(String login, String pass){
        try {
            FileReader filereader = new FileReader();
            BufferedReader bufferedreader = filereader.getBufferedReader("users.csv");

            String cred;
            String str[];
            while ((cred = bufferedreader.readLine()) != null) {
                str = cred.split("\\|");
                if (login.compareTo(str[0]) == 0){
                    if (pass.compareTo(str[1]) == 0){
                        return "Access";
                    } else {
                        return "Denied";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Denied";
    }
}
