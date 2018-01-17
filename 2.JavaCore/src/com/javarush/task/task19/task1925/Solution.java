package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String fileString = "";
        while (fileReader.ready()){
            fileString += fileReader.readLine() + " ";
        }
        fileReader.close();

        String[] str = fileString.split("\\s+");
        String result = "";

        for (String s: str){
            if (s.length() > 6)
                result += s + " ";
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        fileWriter.write(result.trim().replaceAll(" ", ","));
        fileWriter.close();
    }
}