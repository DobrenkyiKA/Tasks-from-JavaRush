package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> treeMap = new TreeMap<>();
        while (bufferedReader.ready()) {
            String[] str = bufferedReader.readLine().split(" ");
            if (treeMap.containsKey(str[0])) {
                treeMap.put(str[0], treeMap.get(str[0]) + Double.parseDouble(str[1]));
            } else treeMap.put(str[0], Double.parseDouble(str[1]));
        }
        bufferedReader.close();
        for (Map.Entry<String, Double> map : treeMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
