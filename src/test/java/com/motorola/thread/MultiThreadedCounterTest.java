package com.motorola.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class MultiThreadedCounterTest {

    @Test
    public void shouldBeZeroOnCreation(){
        MultiThreadedCounter sut = new MultiThreadedCounter(r -> r.run());

        assertEquals(0, sut.getCounter());
    }

    @Test
    public void shouldBe1000AfterOnePassOfCounting(){
        MultiThreadedCounter sut = new MultiThreadedCounter(r -> r.run());

        sut.countTo1000();

        System.out.println("Thread start " + Thread.currentThread().getId());

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        assertEquals(1000, sut.getCounter());
    }


}