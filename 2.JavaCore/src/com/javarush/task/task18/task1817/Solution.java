package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try (FileInputStream file = new FileInputStream(args[0])) {
            int symbols = 0;
            int spaces = 0;

            while (file.available() > 0) {
                symbols++;
                if (file.read() == ' ') spaces++;
            }

            System.out.printf("%.2f",(1.0 * spaces)/symbols * 100);

            } catch (FileNotFoundException e) {} catch (IOException e) {
            e.printStackTrace();
        }
    }
}
