package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String sname;
        private String secname;
        private int old;
        private boolean sex;
        private double member;

        public Human(String name) { }
        public Human(String name, String sname) { }
        public Human(String name, String sname, String secname) { }
        public Human(String name, String sname, String secname, int old) { }
        public Human(String name, String sname, String secname, int old, boolean sex) { }
        public Human(String name, String sname, String secname, int old, boolean sex, double member) { }
        public Human(boolean member){}
        public Human(double member) {}
        public Human(int old){}
        public Human(boolean member, int old){}


    }

}
