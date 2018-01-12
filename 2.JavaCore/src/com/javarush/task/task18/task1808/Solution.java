package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream outputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream outputStream1 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            if ((inputStream.available() % 2) > 0) {
                int i = inputStream.available() / 2;
                byte[] b = new byte[i + 1];
                inputStream.read(b);
                outputStream.write(b);
                inputStream.read(b);
                outputStream1.write(b, 0, i);

            } else {
                int i = inputStream.available() / 2;
                byte[] b = new byte[i];
                inputStream.read(b);
                outputStream.write(b);
                inputStream.read(b);
                outputStream1.write(b);
            }
        } catch (FileNotFoundException e) {}
        catch (IOException e) {}

    }
}
