package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/*
Что внутри папки?
*/
public class Solution {
    public static int amountFiles = 0;
    public static int amountFolders = 0;
    public static long amountBytesInAllFiles = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Path paths = Paths.get(reader.readLine());

            if (Files.isDirectory(paths)) {
                Files.walkFileTree(paths, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        amountFiles++;
                        amountBytesInAllFiles += Files.size( file );
                        return super.visitFile( file, attrs );
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        if (!dir.equals( paths )) {
                            amountFolders++;
                        }
                        return super.postVisitDirectory( dir, exc );
                    }

                });

                System.out.println("Всего папок - " + amountFolders);
                System.out.println("Всего файлов - " + amountFiles);
                System.out.println("Общий размер - " + amountBytesInAllFiles);


            } else System.out.println(paths.toString() + " - не папка");
        } catch (IOException e) {}
    }
}
