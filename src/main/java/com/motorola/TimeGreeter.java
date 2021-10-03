package com.motorola;

import java.time.LocalTime;
import java.util.function.Supplier;

public class TimeGreeter implements Greeter {

    private final Supplier<LocalTime> localTime;

    public TimeGreeter(Supplier<LocalTime> localTimeSupplier) {
        this.localTime = localTimeSupplier;
    }


    String welcomeGuest(LocalTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Gdzie mi z tym nullem chamie!");
        }
        if (time.getHour() <= 12) {
            return "Good morning!";
        } else if (time.getHour() < 18) {
            return "Good afternoon!";
        } else {
            return "Good evening!";
        }
    }

    @Override
    public String welcomeGuest() {
        LocalTime now = getCurrentTime();
        return welcomeGuest(now);
    }

    LocalTime getCurrentTime() {
        LocalTime now = localTime.get();
        return now;
    }
}
