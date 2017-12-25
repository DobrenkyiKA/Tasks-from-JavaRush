package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public Solution() throws IOException {
    }

    public static void main(String[] args) throws Exception {


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pervoeChislo=0;
        int vtoroeChislo=0;

        pervoeChislo = Integer.parseInt(reader.readLine());
        vtoroeChislo = Integer.parseInt(reader.readLine());
        if (pervoeChislo <= 0 || vtoroeChislo <= 0) { throw new Exception();}


    int i = 0;

        if (pervoeChislo < 0) pervoeChislo = -pervoeChislo;
        if (vtoroeChislo < 0) vtoroeChislo = -vtoroeChislo;

        if (pervoeChislo < vtoroeChislo) {i = pervoeChislo;}
        else {i = vtoroeChislo;}
        for (; i > 0; i--) {
            double a = pervoeChislo % i;
            double b = vtoroeChislo % i;
            if (a == b && a == 0) {
                System.out.println(i);
                break;
            }
        }
}
}
