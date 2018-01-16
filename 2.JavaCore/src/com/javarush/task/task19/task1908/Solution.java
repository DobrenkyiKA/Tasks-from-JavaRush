package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            while (fileReader.ready()){
                String[] aStr = fileReader.readLine().split(" ");
                for (String s : aStr) {
                    try {
                        fileWriter.write(Integer.parseInt(s) + " ");
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}
