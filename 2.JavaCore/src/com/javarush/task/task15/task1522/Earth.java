package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private Earth() {}
    private static Earth instance;
    private static class GetEarth {
        private static final Earth instance = new Earth();
    }
    public static Earth getInstance() {
        return instance = GetEarth.instance;
    }
}