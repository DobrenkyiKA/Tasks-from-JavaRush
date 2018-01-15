package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;



public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> treeMap = new TreeMap<>();
        for (char i = 0; i < 127; i++) {
            treeMap.put(i, 0);
        }
        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            while (inputStream.available() > 0) {
                char i = (char) inputStream.read();
                treeMap.put(i, treeMap.get(i) + 1);
            }
        }   catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}

        for (Map.Entry<Character,Integer> entry :treeMap.entrySet()) {
            if (entry.getValue() > 0) System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
