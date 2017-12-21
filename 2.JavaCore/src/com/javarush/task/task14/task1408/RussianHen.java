package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    int getCountOfEggsPerMonth(){
        return 70;
    }
    String getDescription(){
        return (super.getDescription() + " Моя страна - Russia. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
