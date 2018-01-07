package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String url = new BufferedReader(new InputStreamReader(System.in)).readLine();

        url = url.substring(url.indexOf("?") + 1).replace("&", " ");

        System.out.println(url.replaceAll("=\\S+", ""));

        if (url.contains("obj")) {
            url = url.substring(url.indexOf("=") + 1, url.indexOf(" "));
            if (url.matches("\\d+.\\d+"))
                alert(Double.valueOf(url));
            else
                alert(url);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
