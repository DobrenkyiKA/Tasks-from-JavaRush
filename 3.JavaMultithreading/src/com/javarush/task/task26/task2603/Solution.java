package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }
    public static class CustomizedComparator<T> implements Comparator<T> {
        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        private Comparator<T>[] comparators;

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) break;
            }
            return result;
        }
    }
}
