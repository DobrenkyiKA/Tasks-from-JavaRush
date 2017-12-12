package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        Map<String,String> cityfam = new HashMap<>(); // Создание списка с адресами жильцов
        while (true) {
            String city = reader.readLine();          //Считываем Фамилию
            if (city.isEmpty()) break;                //Если ввели пустое поле - останавливаем ввод
            String secondName = reader.readLine();
            cityfam.put(city, secondName);                      // Добавляем считанную фамилию в список
        }

        //read home number
        String city2 = reader.readLine();    //Считываем номер дома
        System.out.println(cityfam.get(city2));

        }
    }

