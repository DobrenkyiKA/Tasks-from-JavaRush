package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       // SimpleObject<String> stringObject = new StringObject<Object>();
    }

    public static class StringObject implements SimpleObject{


        @Override
        public SimpleObject getInstance() {
            return null;
        }
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

}
