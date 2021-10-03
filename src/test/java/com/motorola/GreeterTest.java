package com.motorola;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeGreeterTest {

    @Test
    public void saysGoodMorningAtMidnight() {
        //given
        LocalTime time = LocalTime.of(0, 0);
        Greeter greeter = new TimeGreeter(() -> time);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodEveningBeforeMidnight() {
        //given
        LocalTime time = LocalTime.of(23, 59);
        Greeter greeter = new TimeGreeter(() -> time);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good evening!", result);
    }

    @Test
    public void saysGoodMorningBeforeNoon() {
        //given
        LocalTime time = LocalTime.of(11, 59);
        Greeter greeter = new TimeGreeter(() -> time);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodMorningAtNoon() {
        //given
        LocalTime time = LocalTime.of(12, 00);
        Greeter greeter = new TimeGreeter(() -> time);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodAfternoonAfterNoon() {

        //given
        LocalTime time = LocalTime.of(12, 01);
        Greeter greeter = new TimeGreeter(() -> time);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good afternoon!", result);
    }

    @Test
    public void saysGoodEveningAfter18() {

        //given
        LocalTime time = LocalTime.of(18, 01);
        Greeter greeter = new TimeGreeter(() -> time);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good evening!", result);
    }

    @Test
    public void throwsIllegalArgumentException() {
        //Given
        Greeter greeter = new TimeGreeter(() -> null);


        //when / then
        assertThrows(IllegalArgumentException.class, () -> greeter.welcomeGuest());
    }
}