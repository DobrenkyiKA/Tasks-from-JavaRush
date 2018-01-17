package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);
        Matcher m = Pattern.compile("(\\d+) ([\\+\\-\\*]) (\\d+)").matcher(result);
        m.find();
        int x = Integer.parseInt(m.group(1)),
            y = Integer.parseInt(m.group(3)),
            z = 0;

        switch (m.group(2)) {
            case "+": {z = x + y; break;}
            case "-": {z = x - y; break;}
            case "*": {z = x * y; break;}
        }
        System.out.println(x + " " + m.group(2) + " " + y + " = " + z);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

