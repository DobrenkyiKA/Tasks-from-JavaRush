package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = array.get(0);
        for (int i = 0; i < array.size(); i++)

        {
            if (array.get(i) < min)
                min = array.get(i);
        }
        // find minimum here — найти минимум тут
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String N = reader.readLine();
        int iN = Integer.parseInt(N);
        List<Integer> listok = new ArrayList<>(iN);
        for (int i = 0; i < iN; i++) {
        String chislo_s_klaviaturi = reader.readLine();
        int ichislo_s_klaviaturi = Integer.parseInt(chislo_s_klaviaturi);
        listok.add(ichislo_s_klaviaturi);
        }
        //create and initialize a list here - создать и заполнить список тут
        return listok;
    }
}
