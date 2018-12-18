package edu;

import java.io.BufferedReader;
import java.util.Scanner;

public class Quiz {

    public String getQuestion(int questionNumber) {
        if (questionNumber < 1) return "\nВопрос с указанным номером отсутствует!";

        try {
            FileReader filereader = new FileReader();
            BufferedReader bufferedreader = filereader.getBufferedReader("questions.csv");
            Scanner in = new Scanner(System.in);

            String string;
            String str[] = {"", ""};
            String answer;

            for (int i = 1; i <= questionNumber; i++){
                if ((string = bufferedreader.readLine()) != null) {
                    str = string.split("\\|");
                } else {
                    return "\nВопрос с указанным номером отсутствует!";
                }
            }

            System.out.print("\n" + str[0] + "\nВведите ответ буквами: ");
            answer = in.nextLine().toLowerCase();
            if (answer.compareTo(str[1]) != 0){
                return "Не верный ответ! В свледующий раз повезет!\n";
            } else {
                return "Бинго!\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Что-то пошло не так!";
    }
}
