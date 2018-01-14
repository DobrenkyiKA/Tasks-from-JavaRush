package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int chCount = 0;

        FileInputStream fi = new FileInputStream(args[0]);

        while(fi.available() > 0) {
            int bt = fi.read();
            for (int i = 65; i < 91; i++) {
                if(i==bt) {
                    chCount++;
                }
            }
            for (int i = 97; i < 123; i++) {
                if(i==bt) {
                    chCount++;
                }
            }
        }
        fi.close();
        System.out.println(chCount);
    }
}
