package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date(reader.readLine());
        SimpleDateFormat sData = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String result = sData.format(date);

        System.out.println(result.toUpperCase());

    }
}
