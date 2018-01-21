package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        ArrayDeque<File> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(new File(root));
        do {
            File[] files = arrayDeque.pollFirst().listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    arrayDeque.addLast(file);
                } else list.add(file.getAbsolutePath());
            }
        } while (!arrayDeque.isEmpty());
        return list;

    }

    public static void main(String[] args) {
        
    }
}
