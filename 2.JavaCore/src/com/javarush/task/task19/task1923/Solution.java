package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        while (fileReader.ready()) {
            String[] aStr = fileReader.readLine().split(" ");

            for (String s: aStr) {
                Pattern p = Pattern.compile("[\\d]");
                Matcher m = p.matcher(s);

                if (m.find())
                    fileWriter.write(s + " ");
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
