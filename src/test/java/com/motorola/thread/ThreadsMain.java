package com.motorola.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        MultiThreadedCounter multiThreadedCounter = new MultiThreadedCounter(executor);
        multiThreadedCounter.countTo1000();

        try {
            boolean terminated = executor.awaitTermination(5, TimeUnit.SECONDS);
            if (terminated == false) {
                System.out.println("Błąd!!!!!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        System.out.println(multiThreadedCounter.getCounter());
//        multiThreadedCounter.countTo1000();

        try {
            executor.awaitTermination(100000, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(multiThreadedCounter.getCounter());


        try {
            executor.awaitTermination(100000, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
