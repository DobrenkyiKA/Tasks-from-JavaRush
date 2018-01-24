package com.javarush.task.task31.task3107;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        Path files = Paths.get(pathToFile);
        try {
            fileData = new ConcreteFileData(Files.isHidden(files), Files.isExecutable(files), Files.isDirectory(files), Files.isWritable(files));
        } catch (Exception e) {
            fileData = new NullFileData(e);

        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
