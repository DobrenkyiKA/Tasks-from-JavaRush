package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        StringBuffer sb = new StringBuffer(s);

        for (int i = 0; i < 40; i++) {


            System.out.println(sb);
            sb.delete(0,1);
        }
        //напишите тут ваш код
    }

}

