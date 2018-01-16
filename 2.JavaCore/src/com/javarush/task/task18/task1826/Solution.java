package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args[0].equals("-e")) {
            try (   FileInputStream inputStream = new FileInputStream(args[1]);
                    FileOutputStream outputStream = new FileOutputStream(args[2])) {
                while (inputStream.available() > 0) {
                    int i = inputStream.read();
                    i = ++i;
                    outputStream.write(i);
                }
            }   catch (IOException e) {}
        }
        else if (args[0].equals("-d")) {
            try (   FileInputStream inputStream = new FileInputStream(args[1]);
                    FileOutputStream outputStream = new FileOutputStream(args[2])) {
                while (inputStream.available() > 0) {
                    int i = inputStream.read();
                    i = --i;
                    outputStream.write(i);
                }
            }   catch (IOException e) {}
        }
    }

}
