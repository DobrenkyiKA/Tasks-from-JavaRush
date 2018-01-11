package com.javarush.task.task17.task1721;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        addToLists();
        new Solution().joinData();
    }

    private static void addToLists() throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner file1 = new Scanner(new FileInputStream(input.nextLine()));
        Scanner file2 = new Scanner(new FileInputStream(input.nextLine()));

        while (file1.hasNext()) {
            allLines.add(file1.nextLine());
        }
        file1.close();
        while (file2.hasNext()) {
            forRemoveLines.add(file2.nextLine());
        }
        file2.close();
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}