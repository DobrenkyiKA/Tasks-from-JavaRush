package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            while (!str.equals("exit")) {
                str = reader.readLine();
                new ReadThread(str).start();
            }
        }   catch (FileNotFoundException e) {}
            catch (IOException e) {}
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                Map<Integer, Integer> treeMap = new TreeMap<>();
                while (inputStream.available() > 0) {
                    int b = inputStream.read();
                    if (treeMap.containsKey(b)) {
                        treeMap.put(b, treeMap.get(b) + 1);
                    } else treeMap.put(b, 1);
                }
                resultMap.put(fileName, Collections.max(treeMap.entrySet(), Map.Entry.comparingByValue()).getKey());
            }   catch (FileNotFoundException e) {}
                catch (IOException e) {}
        }
    }
}
