package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int data2 = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            data2 = inputStream.read();
            while (inputStream.available() > 0) {
                int data = inputStream.read();


                if (data2 > data) data2 = data;
            }
        } catch (FileNotFoundException e) {}
        System.out.println(data2);
    }

}
