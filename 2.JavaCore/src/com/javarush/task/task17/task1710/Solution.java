package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        switch (args[0]) {
            case "-c": {
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd/MM/yyyy");
                Date docDate = null;
                try {
                    docDate = format.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (args[2].contains("м")) {
                    allPeople.add(Person.createMale(args[1], docDate));
                } else if (args[2].contains("ж")){
                    allPeople.add(Person.createFemale(args[1], docDate));
                }
                System.out.println(allPeople.size() - 1);
            }
            break;
            case "-u": {
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd/MM/yyyy");
                Date docDate = null;
                try {
                    docDate = format.parse(args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (args[3].equals("м")) {
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], docDate));
                } else if (args[3].equals("ж")){
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], docDate));
                }
            }
            break;
            case "-d": {
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
            }
            break;
            case "-i": {
                String pol = "";
                if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) {
                    pol = "м";
                } else {
                    pol = "ж";
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.print(allPeople.get(Integer.parseInt(args[1])).getName() + " " + pol + " " + dateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
            }
            break;
        }
    }
}
