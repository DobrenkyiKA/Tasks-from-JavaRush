package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream outputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String[] strings = new String(bytes).split(" ");
            for (String str : strings)
                outputStream.write((Double.toString(Math.round(Double.parseDouble(str))) + " ").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
