package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int id = 0;
        String name = "";
        try {
            do {
                id = Integer.parseInt(reader.readLine());
                name = reader.readLine();
                map.put(name,id);
            } while (name != "");
        } catch (NumberFormatException e) {
            //System.out.println("Говно");
        }

        for (Map.Entry s : map.entrySet())
            System.out.println(s.getValue() + " " + s.getKey());
    }
}
