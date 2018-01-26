package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int a = 0;
        int b = 25;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 3; i++) {
            char random = characters.charAt(a + (int) (Math.random() * b));
            int by = (int) random;
            byteArrayOutputStream.write(by);
        }
        int a1 = 0;
        int b1 = 25;
        String characters1 = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 3; i++) {
            char random = characters1.charAt(a1 + (int) (Math.random() * b1));
            int by = (int) random;
            byteArrayOutputStream.write(by);
        }
        int a2 = 0;
        int b2 = 9;
        String characters2 = "0123456789";
        for (int i = 0; i < 2; i++) {
            char random = characters2.charAt(a2 + (int) (Math.random() * b2));
            int by = (int) random;
            byteArrayOutputStream.write(by);
        }

        return byteArrayOutputStream;
    }
}