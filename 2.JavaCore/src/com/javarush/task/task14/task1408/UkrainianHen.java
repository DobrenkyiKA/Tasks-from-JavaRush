package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    int getCountOfEggsPerMonth(){
        return 80;
    }
    String getDescription(){
        return (super.getDescription() + " Моя страна - Ukraine. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
