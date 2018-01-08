package com.javarush.task.task16.task1610;

/* 
Расставь вызовы методов join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
    }

    private static void investigateWorld() throws InterruptedException {
        Thread.sleep(200);
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) throws InterruptedException {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());

            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            start();

        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                initAllKitten();
            } catch (InterruptedException e) {
            }
            try {
                kitten2.join();
                kitten1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKitten() throws InterruptedException {
            kitten1.start();
            kitten2.start();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + ", вылез из корзинки");
            try {
                investigateWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
