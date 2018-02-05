package com.javarush.task.task33.task3308;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public int count;
    public double profit;
    public String[] secretData;
    public Goods goods;

    public static class Goods {
        public List<String> names;
    }
}
