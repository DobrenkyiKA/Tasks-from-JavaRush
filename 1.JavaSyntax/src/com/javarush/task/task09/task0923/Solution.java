package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String setString = reader.readLine();
        String breakSetString[] = setString.split(" ");
        String vowelSting = "", unVowelString = "";
        for (int i = 0; i < breakSetString.length; i++) {
                String oneWords = breakSetString[i];
                for (int g = 0; g < oneWords.length(); g++) {
                    char myChar = oneWords.charAt(g);
                    if (isVowel(myChar)) {
                        vowelSting += myChar + " ";
                    }
                    else unVowelString += myChar + " ";
                }
        }
        System.out.println(vowelSting);
        System.out.println(unVowelString);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}