package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int data2 = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();

                if (data2 < data) data2 = data;
            }
        } catch (FileNotFoundException e) {}
        System.out.println(data2);
    }

}
