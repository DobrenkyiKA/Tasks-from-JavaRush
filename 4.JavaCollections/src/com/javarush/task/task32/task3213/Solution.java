package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        try (BufferedReader br = new BufferedReader(reader);
             StringWriter stringWriter = new StringWriter()) {
                String line = br.readLine();
                StringBuffer sb = new StringBuffer(line);
                for (int i = 0; i < line.length(); i++) {
                    sb.setCharAt(i, (char) (sb.charAt(i) + key));
                }
                stringWriter.write(sb.toString());
            return stringWriter.toString();
        } catch (Exception e) {e.printStackTrace(); return ""; }
    }
}
