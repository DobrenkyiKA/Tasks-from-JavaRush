package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Horse getWinner(){
        int dist = 0;
        Horse nameWinner = null;
        for (int i = 0; i < getHorses().size() ; i++) {
            if (getHorses().get(i).getDistance() > dist) {
                dist = (int)getHorses().get(i).getDistance();
                nameWinner = getHorses().get(i);
            }
        }
    return nameWinner;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (int i = 0; i < getHorses().size() ; i++) {
            getHorses().get(i).move();
        }
    }
    public void print() {
        for (int i = 0; i < getHorses().size() ; i++) {
            getHorses().get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> hor = new ArrayList<Horse>();
        hor.add(new Horse("One",3.0, 0.0));
        hor.add(new Horse("Two",3.0, 0.0));
        hor.add(new Horse("Three",3.0, 0.0));
        game = new Hippodrome(hor);
        game.run();
        game.printWinner();
    }
}
