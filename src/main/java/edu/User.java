package edu;

import java.io.*;

public class User{
    public void getUser(String user) throws Exception {
        try {
            FileReader filereader = new FileReader();
            BufferedReader bufferedreader = filereader.getBufferedReader("users.csv");
            String nextLine = bufferedreader.readLine();
            System.out.println(nextLine);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}