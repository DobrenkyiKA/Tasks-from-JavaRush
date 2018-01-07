package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = reader.readLine();
            if (string.equals("helicopter")) {result = new Helicopter();}
            else if (string.equals("plane")) {
                string = reader.readLine();

                result = new Plane(Integer.parseInt(string));
            }

        } catch (IOException e) {}
    }
}
