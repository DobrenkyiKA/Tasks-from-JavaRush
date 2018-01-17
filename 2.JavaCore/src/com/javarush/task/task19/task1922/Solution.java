package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Scanner fileReader = new Scanner(new FileReader(fileName));

        while (fileReader.hasNext()){
            int count = 0;
            String line = fileReader.nextLine();
            String[] str = line.split(" ");
            for (String s: words){
                for (String sl: str){
                    if (s.equals(sl)) count++;
                }
            }
            if (count == 2) System.out.println(line);
        }

        fileReader.close();
    }
}