package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        Movie movie;
        while (key.equals("soapOpera")||key.equals("cartoon")||key.equals("thriller")){
            movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
            key=reader.readLine();
        }
        movie=MovieFactory.getMovie(key);

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            } else if("cartoon".equals(key)) {
                movie = new Cartoon();
            }



            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie{

    }
}
