package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        int count = 0;
        while (fileReader.ready()){
            String str = fileReader.readLine().replaceAll("[^a-zA-Z]", ",");
            String[] aStr = str.split(",");
            for (int i = 0; i < aStr.length; i++) {
                if (aStr[i].equals("world")) count++;
            }
        }

        fileReader.close();

        System.out.println(count);
    }
}