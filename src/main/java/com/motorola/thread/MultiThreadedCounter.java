package com.motorola.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreadedCounter {

    private volatile long counter;
    private final Executor executor;

    public MultiThreadedCounter(Executor executor) {
        this.executor = executor;
    }

    public void countTo1000() {

        Runnable countTo500 = () -> {
            System.out.println("Thread start " + Thread.currentThread().getId());
            for (int i = 0; i < 500; i++) {
                counter++;

            }
        };

        executor.execute(countTo500);
        executor.execute(countTo500);

     }

    public long getCounter() {
        return counter;
    }

}
