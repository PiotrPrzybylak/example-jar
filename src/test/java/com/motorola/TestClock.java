package com.motorola;

import java.time.LocalTime;

public class TestClock implements Clock {


    public TestClock(LocalTime time) {
        this.time = time;
    }

    private LocalTime time;

    @Override
    public LocalTime currentTime() {
        return time;
    }
}
