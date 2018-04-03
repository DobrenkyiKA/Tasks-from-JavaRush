package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {


    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        int iterator = 0;
        for (Map.Entry entry: params.entrySet()){
            if (entry.getValue() != null) {
                if (iterator != 0) stringBuilder.append(" and ");
                stringBuilder.append(entry.getKey() + " = '" + entry.getValue() + "'");
                iterator++;
            }
            
        }
        
        return stringBuilder.toString();
    }
}
