package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    int getCountOfEggsPerMonth(){
        return 60;
    }
    String getDescription(){

        return (super.getDescription() + " Моя страна - Moldova. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
