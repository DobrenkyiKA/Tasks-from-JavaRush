package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;


        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public Person read() throws IOException {
            String[] aLine = fileScanner.nextLine().split(" ");
            String lastName = aLine[0]; //Фамилия
            String firstName = aLine[1]; //Имя
            String middleName = aLine[2]; //Отчество

            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = new Date();
            try {
                birthDate = format.parse(aLine[3] + " " + aLine[4] + " " + aLine[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person( firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
