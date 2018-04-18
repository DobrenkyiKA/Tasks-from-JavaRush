package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels = new ArrayList<>();

        public Car() {
            for (Wheel wheel : Wheel.values()) {
                if ((wheel.toString() != loadWheelNamesFromDB()[0] && wheel.toString() != loadWheelNamesFromDB()[1] && wheel.toString() != loadWheelNamesFromDB()[2] && wheel.toString() != loadWheelNamesFromDB()[3]) || loadWheelNamesFromDB().length > 4) {
                    throw new IllegalArgumentException();
                } else wheels.add(wheel);
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
