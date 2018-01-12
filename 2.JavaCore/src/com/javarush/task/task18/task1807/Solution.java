package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
    try (FileInputStream fileInput = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
        int coint = 0;
        byte b = 44;
        while (fileInput.available() > 0) {
            if (fileInput.read() == b) coint++;
        }
        System.out.println(coint);
    } catch (IOException e) {}
    }

}
