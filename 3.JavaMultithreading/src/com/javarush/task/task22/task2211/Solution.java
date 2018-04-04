package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");


        try(    FileInputStream inputStream = new FileInputStream(args[0]);
                FileOutputStream outputStream = new FileOutputStream(args[1])
        )
        {
            //создаем buffer размером содержимого первого сайта
            byte[] buffer = new byte[inputStream.available()];
            // читаем содержимое в переменную buffer
            inputStream.read(buffer);
            // читаем сожержимое buffer в строку в кодировке UTF-8
            String s = new String(buffer, windows1251);

            // Меняем кодировку
            // записываем строку в buffer в кодировке Windows1251
            buffer = s.getBytes(utf8);
            // пишем в файл
            outputStream.write(buffer);
        }

    }
}