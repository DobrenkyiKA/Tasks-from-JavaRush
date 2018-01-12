package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream;
        do {stream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } while (stream.available() > 999);
        stream.close();
        throw new DownloadException();
        }


    public static class DownloadException extends IOException {


    }
}
