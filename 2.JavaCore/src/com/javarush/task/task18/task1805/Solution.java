package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader
                (new InputStreamReader(System.in)).readLine());
        ArrayList<Byte> list = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            list.add((byte) fileInputStream.read());
        }

        Map<Byte, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            System.out.print(pair.getKey() + " ");
        }
        fileInputStream.close();
    }
}