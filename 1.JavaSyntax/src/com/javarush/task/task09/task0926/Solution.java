package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> listok = new ArrayList<>(5);
        int[] mass1 = {1,1,1,1,1};
        int[] mass2 = {2,2};
        int[] mass3 = {3,3,3,3};
        int[] mass4 = {4,4,4,4,4,4,4};
        int[] mass5 = {};
        listok.add(0,mass1);
        listok.add(1,mass2);
        listok.add(2,mass3);
        listok.add(3,mass4);
        listok.add(4,mass5);


        return listok;//напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
