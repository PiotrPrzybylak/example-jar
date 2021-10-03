package com.motorola;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TimeGreeterTest {

    @Test
    public void saysGoodMorningAtMidnight() {
        //given
        Clock clock = () -> LocalTime.of(0, 0);
        Greeter greeter = new TimeGreeter(clock, null);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodEveningBeforeMidnight() {
        //given
        LocalTime time = LocalTime.of(23, 59);

        Clock clock = Mockito.mock(Clock.class);
        when(clock.currentTime()).thenReturn(time);

        Greeter greeter = new TimeGreeter(() -> time, null);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good evening!", result);
    }

    @Test
    public void saysGoodMorningBeforeNoon() {
        //given
        LocalTime time = LocalTime.of(11, 59);
        Greeter greeter = new TimeGreeter(() -> time, null);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodMorningAtNoon() {
        //given
        LocalTime time = LocalTime.of(12, 00);
        Greeter greeter = new TimeGreeter(() -> time, null);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good morning!", result);
    }

    @Test
    public void saysGoodAfternoonAfterNoon() {

        //given
        LocalTime time = LocalTime.of(12, 01);
        Greeter greeter = new TimeGreeter(() -> time, () -> true);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good afternoon!", result);
    }

    @Test
    public void saysHiAfterNoon() {

        //given
        LocalTime time = LocalTime.of(12, 01);
        Greeter greeter = new TimeGreeter(() -> time, () -> false);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Hi!", result);
    }

    @Test
    public void saysGoodEveningAfter18() {

        //given
        LocalTime time = LocalTime.of(18, 01);
        Greeter greeter = new TimeGreeter(() -> time, null);

        //when
        String result = greeter.welcomeGuest();

        //then
        assertEquals("Good evening!", result);
    }

    @Test
    public void throwsIllegalArgumentException() {
        //Given
        Greeter greeter = new TimeGreeter(() -> null, null);


        //when / then
        assertThrows(IllegalArgumentException.class, () -> greeter.welcomeGuest());
    }
}