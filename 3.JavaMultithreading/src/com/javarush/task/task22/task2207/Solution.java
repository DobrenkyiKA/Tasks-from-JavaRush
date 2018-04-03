package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (FileReader fileReader = new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine())) {

            StringBuilder stringBuilder = new StringBuilder();
            int input;
            while ((input = fileReader.read()) != -1) {
                stringBuilder.append((char) input);
            }
            ArrayList<String> arrayString = new ArrayList<>(Arrays.asList(stringBuilder.toString().split("[ \r\n]")));


            for (int i = 0; i < arrayString.size(); i++) {
                for (int j = i + 1; j < arrayString.size(); j++) {
                    String revers = new StringBuilder(arrayString.get(j)).reverse().toString();
                    if (arrayString.get(i).equals(revers)) {
                        Pair pair = new Pair();
                        pair.first = arrayString.get(i);
                        pair.second = arrayString.get(j);
                        result.add(pair);
                        arrayString.remove(i);
                        arrayString.remove(j - 1);
                        i = 0;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        }

        public static class Pair {
            String first;
            String second;

            public Pair(String first, String second) {
                this.first = first;
                this.second = second;
            }

            public Pair() {
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Pair pair = (Pair) o;

                if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
                return second != null ? second.equals(pair.second) : pair.second == null;

            }

            @Override
            public int hashCode() {
                int result = first != null ? first.hashCode() : 0;
                result = 31 * result + (second != null ? second.hashCode() : 0);
                return result;
            }

            @Override
            public String toString() {
                return first == null && second == null ? "" :
                        first == null && second != null ? second :
                                second == null && first != null ? first :
                                        first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

            }
        }

}
