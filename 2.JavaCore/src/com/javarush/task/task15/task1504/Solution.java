package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        abstract public Book getBook();

        abstract public String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ", " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " book was written by " + author;

            String output = "output";
            if (this instanceof MarkTwainBook) output = markTwainOutput ;
            if (this instanceof AgathaChristieBook) output = agathaChristieOutput ;
            return output;
        }
        public String toString() {return getOutputByBookType();}
    }
    public static class MarkTwainBook extends Book {
        String title;
        public MarkTwainBook(String nameBook) {
            super("Mark Twain");
            this.title = nameBook;
        }

        public MarkTwainBook getBook() {return this;}
        public String getTitle() {return title;}
    }
    public static class AgathaChristieBook extends Book {
        String title;
        public AgathaChristieBook(String nameBook) {
            super("Agatha Christie");
            title = nameBook;
        }

        public AgathaChristieBook getBook() {return this;}
        public String getTitle() {return title;}
    }

}
