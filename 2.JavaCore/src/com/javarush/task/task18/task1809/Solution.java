package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream outputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            int b[] = new int[inputStream.available()];
            for (int i = 0; b.length -1 >= i; i++) {
                b[i] = inputStream.read();
                System.out.println(b[i]);
            }
            for (int i = b.length - 1; 0 <= i; i--) {
                outputStream.write(b[i]);
                System.out.println(b[i]);
            }
        } catch (FileNotFoundException e) {}
        catch (IOException e) {}

    }
}
