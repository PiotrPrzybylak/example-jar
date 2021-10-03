package com.motorola;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.function.Supplier;

@Configuration
public class SpringConfig {

    @Bean
    public Clock supplier() {
        return LocalTime::now;
    }

    @Bean
    public Supplier<Long> temperatureSupplier() {
        return () -> 5L;
    }


}
