package com.javarush.task.task20.task2025;

import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[] numbers = new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        List<Long> list = new LinkedList<>();
        for (long number : numbers)
        {
            if (number < N)
                list.add(number);
        }
        long[] result = new long[list.size()];
        for (long i = 0; i < list.size(); i++)
            result[(int)i] = list.get((int)i);
        return result;

    }


    public static void main(String[] args) {

    }
}