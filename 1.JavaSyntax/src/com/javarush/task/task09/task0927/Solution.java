package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> mapCat = new HashMap<>();
        mapCat.put("A", new Cat("A"));
        mapCat.put("Б", new Cat("Б"));
        mapCat.put("В", new Cat("В"));
        mapCat.put("Г", new Cat("Г"));
        mapCat.put("Д", new Cat("Д"));
        mapCat.put("Е", new Cat("Е"));
        mapCat.put("Ё", new Cat("Ё"));
        mapCat.put("Ж", new Cat("Ж"));
        mapCat.put("З", new Cat("З"));
        mapCat.put("И", new Cat("И"));
        return mapCat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        HashSet<Cat> hashCat = new HashSet<>();
        for (Cat i : map.values())
            hashCat.add(i);
        return hashCat;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
