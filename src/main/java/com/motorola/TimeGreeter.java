package com.motorola;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TimeGreeter implements Greeter {

    private final Clock clock;
    private final CoinFlipper random;

    public TimeGreeter(Clock clock, CoinFlipper random) {
        this.clock = clock;
        this.random = random;
    }

    private String welcomeGuest(LocalTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Gdzie mi z tym nullem chamie!");
        }
        if (time.getHour() < 12  ) {
            return "Good morning!";
        } else if (time.getHour() == 12 && time.getMinute() == 0) {
            return "Good morning!";
        } else if (time.getHour() < 18) {
            if (random.isHeads()) {
                return "Good afternoon!";
            } else {
                return "Hi!";
            }
        } else {
            return "Good evening!";
        }
    }

    @Override
    public String welcomeGuest() {
        LocalTime now = getCurrentTime();
        return welcomeGuest(now);
    }

    private LocalTime getCurrentTime() {
        return clock.currentTime();
    }

    public interface CoinFlipper {

        boolean isHeads();

    }
}