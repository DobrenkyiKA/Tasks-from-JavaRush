package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        reader.close();

        String file = "";
        while (scanner.hasNext()){
            file = file + scanner.nextLine() + "\n";
        }
        scanner.close();

        Pattern pattern = Pattern.compile("\\d+\\s");
        Matcher matcher = pattern.matcher(file);

        while (matcher.find()){
            int n = Integer.parseInt(matcher.group().trim());
            if (map.containsKey(n)){
                String addSpace = map.get(n) + " ";
                file = file.substring(0, matcher.start())+ addSpace + file.substring(matcher.end());
                matcher = pattern.matcher(file);
            }
        }

        System.out.println(file);
    }
}