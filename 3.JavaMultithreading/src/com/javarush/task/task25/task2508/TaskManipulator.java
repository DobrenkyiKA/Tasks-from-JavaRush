package com.javarush.task.task25.task2508;

import static java.lang.Thread.sleep;

public class TaskManipulator implements Runnable, CustomThreadManipulator{
    Thread thread;
    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                System.out.println(thread.getName());
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
           // e.printStackTrace();
        }

    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();

    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
