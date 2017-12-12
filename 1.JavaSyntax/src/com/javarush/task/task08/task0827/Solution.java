package com.javarush.task.task08.task0827;

import java.util.Date;
import java.util.*;
import java.text.*;
/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 2 2013"));
    }

    public static boolean isDateOdd(String date) {

        SimpleDateFormat format = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        Date dayWeek = null;
        try {
            dayWeek = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String f = new SimpleDateFormat("DDD").format(dayWeek);
        double dd = Integer.parseInt(f);
        if (dd % 2 == 0) return false;
        return true;
    }
}
