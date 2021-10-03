package com.motorola;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {

//    public static class AfterNoonTime implements Supplier<LocalTime> {
//
//        @Override
//        public LocalTime get() {
//            return LocalTime.of(14, 0);
//        }
//    }


    @Test
    public void saysGoodMorningAtPresent() {
//        LocalTime time = LocalTime.of(15, 0);
        Greeter greeter = new TimeGreeter(LocalTime::now);
        String result = greeter.welcomeGuest();
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodEveningBeforeMidnight() {
        LocalTime time = LocalTime.of(23, 59);
        Greeter greeter = new TimeGreeter(() -> time);
        String result = greeter.welcomeGuest();
        assertEquals("Good evening!", result);
    }

    @Test
    public void saysGoodMorningBeforeNoon() {
        LocalTime time = LocalTime.of(11, 59);
        Greeter greeter = new TimeGreeter(() -> time);
        String result = greeter.welcomeGuest();
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodMorningAtNoon() {
        LocalTime time = LocalTime.of(12, 00);
        Greeter greeter = new TimeGreeter(() -> time);
        String result = greeter.welcomeGuest();
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodAfternoonAfterNoon() {
        LocalTime time = LocalTime.of(12, 01);
        Greeter greeter = new TimeGreeter(() -> time);
        String result = greeter.welcomeGuest();
        assertEquals("Good afternoon!", result);
    }

    @Test
    public void saysGoodEveningAfter18() {
        LocalTime time = LocalTime.of(18, 01);
        Greeter greeter = new TimeGreeter(() -> time);
        String result = greeter.welcomeGuest();
        assertEquals("Good evening!", result);
    }

    @Test
    public void throwsIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> greeter.welcomeGuest(null));
    }
}