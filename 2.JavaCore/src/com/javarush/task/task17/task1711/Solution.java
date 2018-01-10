package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    int iter = -1;
                    int loop = (args.length - 1) / 3;
                    for (int i = 1; i <= loop; i++) {
                        SimpleDateFormat format = new SimpleDateFormat();
                        format.applyPattern("dd/MM/yyyy");
                        Date docDate = null;
                        try {
                            docDate = format.parse(args[3 * i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        iter = iter + 3;
                        if (args[iter].contains("м")) {
                            allPeople.add(com.javarush.task.task17.task1711.Person.createMale(args[iter - 1], docDate));
                        } else if (args[iter].contains("ж")) {
                            allPeople.add(com.javarush.task.task17.task1711.Person.createFemale(args[iter - 1], docDate));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                }
            }
            break;
            case "-u": {
                synchronized (allPeople) {
                    int iter = -1;
                    int loop = (args.length - 1) / 4;
                    for (int i = 1; i <= loop; i++) {
                        SimpleDateFormat format = new SimpleDateFormat();
                        format.applyPattern("dd/MM/yyyy");
                        Date docDate = null;
                        iter = iter + 4;
                        try {
                            docDate = format.parse(args[iter + 1]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (args[iter].equals("м")) {
                            allPeople.set(Integer.parseInt(args[iter - 2]), com.javarush.task.task17.task1711.Person.createMale(args[iter - 1], docDate));
                        } else if (args[iter].equals("ж")) {
                            allPeople.set(Integer.parseInt(args[iter - 2]), com.javarush.task.task17.task1711.Person.createFemale(args[iter - 1], docDate));
                        }
                    }
                }
            }
            break;
            case "-d": {
                synchronized (allPeople) {
                    int loop = args.length - 1;
                    for (int i = 1; i <= loop; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                    }
                }
            }
            break;
            case "-i": {
                synchronized (allPeople) {
                    int loop = args.length - 1;
                    for (int i = 1; i <= loop; i++) {
                        String pol = "";
                        if (allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.MALE) {
                            pol = "м";
                        } else {
                            pol = "ж";
                        }
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + pol + " " + dateFormat.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                    }
                }
            }
            break;
        }
    }
}
