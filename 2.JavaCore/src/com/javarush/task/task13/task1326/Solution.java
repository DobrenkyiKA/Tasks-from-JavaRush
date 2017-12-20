package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;



public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader freader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            ArrayList list = new ArrayList<Integer>();
            String str ="";

            while ((str = freader.readLine()) != null) {
                if ((Integer.parseInt(str)) % 2 == 0) {
                    list.add(Integer.parseInt(str));
                }
            }

            Collections.sort(list);
            list.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }

    }}
