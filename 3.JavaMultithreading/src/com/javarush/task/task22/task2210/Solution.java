package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreTokens()) {
            arrayList.add(tokenizer.nextToken());
        }
        String[] strings = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strings[i] = arrayList.get(i);
        }


        return strings;
    }
}
