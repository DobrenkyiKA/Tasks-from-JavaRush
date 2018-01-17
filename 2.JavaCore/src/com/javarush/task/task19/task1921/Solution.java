package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] name = line.split("\\d+");
            String date = line.replaceAll(name[0], "");

            PEOPLE.add(
                    new Person(name[0].trim(),
                            new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(date))
            );
        }

        bufferedReader.close();

    }
}