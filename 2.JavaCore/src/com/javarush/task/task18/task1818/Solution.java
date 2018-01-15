package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileOutputStream file1 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileInputStream file2 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileInputStream file3 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {

            while (file2.available() > 0) {
                file1.write(file2.read());
            }
            while (file3.available() > 0) {
                file1.write(file3.read());
            }

        } catch (IOException e) {}
    }
}
