package com.javarush.task.task22.task2212;
/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber == "") return false;
        else {
            int i = telNumber.replaceAll("\\D", "").length();
            if ((telNumber.charAt(0) == '+' && i == 12) || (telNumber.charAt(0) != '+' && i == 10)) {
                return telNumber.matches("\\+?\\d+(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+");
            } else return false;
        }
    }

    public static void main(String[] args) {
    }
}
