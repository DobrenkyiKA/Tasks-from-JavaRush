package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        ArrayList<Integer> ab = new ArrayList<>();
        for (int t = 0; t < 33; t++) {
            ab.add(0);
        }

        for (int j = 0; j < 10; j++) {
            String Sstring = list.get(j);
            for (int g = 0; g < Sstring.length(); g++) {
                for (int h = 0; h < 33; h++) {
                    char a = Sstring.charAt(g);
                    char b = alphabet.get(h);
                    if (Math.abs((int)a - (int)b) == 0) {
                        int n = ab.get(h);
                        n = n+1;
                        ab.set(h, n);
                    }
                }
            }
        }
        for (int u = 0; u < 33; u++) {
            System.out.println(alphabet.get(u) + " " + ab.get(u));
        }// напишите тут ваш код
    }

}
