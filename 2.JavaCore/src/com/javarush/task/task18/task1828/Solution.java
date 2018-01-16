package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution{

    private static String fileName;

    static {
        readFileConsole();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 0){
            int productId = Integer.parseInt(args[1]);
            switch (args[0]){
                case "-u":
                    update(productId, args[2], args[3], args[4]);
                    break;
                case "-d":
                    delete(productId);
                    break;
            }

        }
    }

    private static void delete(int productId) throws IOException {
        List<String> lines = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");
        while (in.hasNext()){
            String line = in.nextLine();
            int id = Integer.parseInt(line.substring(0,8).trim());
            if (id != productId)
                lines.add(line);
        }
        in.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        for (String line : lines)
            bufferedWriter.write(line + System.getProperty("line.separator"));

        bufferedWriter.close();
    }

    public static void update(int productId, String productName, String price, String quantity) throws IOException {
        List<String> lines = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");

        while (in.hasNext()){
            String line = in.nextLine();
            int id = Integer.parseInt(line.substring(0,8).trim());
            if (id == productId){
                line = String.format(
                        "%s%s%s%s",
                        stringFormat(Integer.toString(id), 8),
                        stringFormat(productName, 30),
                        stringFormat(price, 8),
                        stringFormat(quantity, 4)
                );
            }
            lines.add(line);
        }

        in.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        for (String line : lines)
            bufferedWriter.write(line + System.getProperty("line.separator"));

        bufferedWriter.close();
    }

    public static void readFileConsole(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String stringFormat(String string, int length){
        if (string.length() > length)
            string = string.substring(0, length);

        if (string.length() < length)
            while (string.length() < length)
                string = string + " ";

        return string;
    }
}