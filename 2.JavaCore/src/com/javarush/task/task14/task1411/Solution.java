package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();

        while (key.equals("user") || key.equals("loser") || key.equals("proger") || key.equals("coder"))
        {   switch (key) {
            case "user": person = new Person.User();
            break;
            case "loser": person = new Person.Loser();
            break;
            case "proger": person = new Person.Proger();
            break;
            case "coder": person = new Person.Coder();
            break;
        }
            doWork(person);
        key = reader.readLine();
        }
    }

    public static void doWork(Person person) {
        switch (person.getClass().getSimpleName()) {
            case "User": ((Person.User) person).live();
            break;
            case "Loser": ((Person.Loser) person).doNothing();
            break;
            case "Proger": ((Person.Proger) person).enjoy();
            break;
            case "Coder": ((Person.Coder) person).coding();
            break;
        }
    }
}
