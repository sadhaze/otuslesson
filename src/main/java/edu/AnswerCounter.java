package edu;

public class AnswerCounter implements IAnswerCounter {
    private int right = 0;
    private int wrong = 0;

    public void setRight(){
        right++;
    }

    public void setWrong(){
        wrong++;
    }

    public String getResult(){
        return "\nВаш результат: " + right + " правильных ответа и " + wrong + " неправильных. Поздравляю!";
    }
}
