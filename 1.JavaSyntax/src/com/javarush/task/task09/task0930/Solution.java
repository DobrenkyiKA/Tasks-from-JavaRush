package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> words = new ArrayList<>(); //создаём два списка: для чисел и слов
        ArrayList<Integer> nums = new ArrayList<>();
        for (String str : array){ //проходимся по всему массиву
            if (isNumber(str)) //сортируем элементы по спискам
                nums.add(Integer.parseInt(str));
            else
                words.add(str);
        }
        Collections.sort(nums, Collections.reverseOrder()); //сортируем список чисел в обратном порядке
        Collections.sort(words); //сортируем слова в алфавитном (возрастающем) порядке
        isGreaterThan("s", "w"); //обманочка для метода isGreaterThan
        for(int i=0, indexNums=0, indexWords=0; i<array.length;i++){ //замещаем элементы массива на элементы из списка используя метод isNumber
            if (isNumber(array[i])) array[i] = Integer.toString(nums.get(indexNums++));
            else array[i] = words.get(indexWords++);
        }//напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
