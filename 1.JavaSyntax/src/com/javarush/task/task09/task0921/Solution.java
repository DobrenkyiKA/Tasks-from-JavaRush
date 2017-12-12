package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> list = new ArrayList<>();
        try {

            for (int i = 0; true; i++) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                list.add(Integer.parseInt(reader.readLine()));
            }
        } catch (Exception e) {
            for (int a: list)
            System.out.println(a);
        }

        //напишите тут ваш код
    }
}
