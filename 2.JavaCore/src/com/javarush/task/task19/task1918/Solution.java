package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String tmp = "";
        while (fileReader.ready())
            tmp += fileReader.readLine();

        fileReader.close();
        String tag = args[0];

        Pattern openTag = Pattern.compile("<"+ tag +".*?>");
        Pattern closeTag = Pattern.compile("</"+ tag +">");

        Matcher open = openTag.matcher(tmp);
        Matcher close = closeTag.matcher(tmp);

        List<Integer> openList = new ArrayList<>();
        List<Integer> closeList = new ArrayList<>();


        while ( open.find() ) {
            openList.add(open.start());
            if (close.find()) closeList.add(close.end());
        }

        while (!openList.isEmpty()){
            int n = 0;
            if (openList.size() > 1 && openList.get(1) < closeList.get(0)){
                n++;
                System.out.println(tmp.substring(openList.remove(0), closeList.remove(n)));
            }
            else
                System.out.println(tmp.substring(openList.remove(0), closeList.remove(0)));
        }
    }
}