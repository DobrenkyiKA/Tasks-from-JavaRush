package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(reader.readLine());
            FileWriter fileWriter = new FileWriter(reader.readLine())) {


            int d;
            for (int i = 1; fileReader.ready() ; i++) {
                d = fileReader.read();
                if (i % 2 == 0) {
                    fileWriter.write(d);
                }
            }
        }
    }
}
