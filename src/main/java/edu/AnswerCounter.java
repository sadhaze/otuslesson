package edu;

public class AnswerCounter {
    private int right = 0;
    private int wrong = 0;

    public void setCount(String answer){
        if ("Бинго!\n".compareTo(answer) == 0) {
            right++;
        } else {
            wrong++;
        }
    }
    public String getResult(){
        return "\nВаш результат: " + right + " правильных ответа и " + wrong + " неправильных. Поздравляю!";
    }
}
