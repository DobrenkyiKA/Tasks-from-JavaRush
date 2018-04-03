package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        String[] words = content.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        int length = words.length;
        ArrayList<String> array = new ArrayList<>();
        ArrayList<String> arrayEnd = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        if (length >= 1) {
            for (int i = 0; i < length; i++) {
                if (arrayEnd.size() == length) break;
                array.clear();
                arrayEnd.clear();
                for (int k = 0; k < length; k++) {
                    array.add(words[k]);
                }
                arrayEnd.add(array.get(i));
                array.remove(i);
                for (int j = 0; j < array.size(); j++) {
                    int charsFirst = arrayEnd.get(arrayEnd.size() - 1).toUpperCase().charAt(arrayEnd.get(arrayEnd.size() - 1).length() - 1);
                    int charsLast = array.get(j).toUpperCase().charAt(0);
                    if (charsFirst == charsLast) {
                        arrayEnd.add(array.get(j));
                        array.remove(j);
                        j = -1;
                    }
                }
            }
        }
        for (int h = 0; h < arrayEnd.size(); h++) {
            if (h == arrayEnd.size() - 1) {
                stringBuilder.append(arrayEnd.get(h));
                break;
            }
            stringBuilder.append(arrayEnd.get(h) + " ");

        }
        return stringBuilder;
    }
}
