package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, byte[]> map = new TreeMap<>();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while (!(fileName = rd.readLine()).equals("end")) {
            FileInputStream fi = new FileInputStream(fileName);
            byte[] buff = new byte[fi.available()];
            fi.read(buff);
            fi.close();

            map.put(fileName, buff);
        }

        FileOutputStream fo = new FileOutputStream(map.firstKey().substring(0, map.firstKey().lastIndexOf('.')));
        for (Map.Entry<String, byte[]> en : map.entrySet()) {
            fo.write(en.getValue());
        }

        rd.close();
        fo.close();
    }
}