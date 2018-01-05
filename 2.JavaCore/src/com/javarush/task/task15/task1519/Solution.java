package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string;
            while(!(string = reader.readLine()).equals("exit")) {
                if (string.contains(".")) {
                    try {
                        print(Double.parseDouble(string));
                    } catch (NumberFormatException e) {
                        try {
                            if (Integer.parseInt(string) > 0 && Integer.parseInt(string) < 128) {
                                print(Short.parseShort(string));
                            } else print(Integer.parseInt(string));
                        } catch (NumberFormatException r) {
                        print(string);
                    }
                    }

                }
                else {
                    try {
                        if (Integer.parseInt(string) > 0 && Integer.parseInt(string) < 128) {
                            print(Short.parseShort(string));
                        } else print(Integer.parseInt(string));
                    } catch (NumberFormatException e) {
                        print(string);
                    }
                }
            }
        }
        catch(IOException e) {
                    System.out.println("fuf fuf");
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
