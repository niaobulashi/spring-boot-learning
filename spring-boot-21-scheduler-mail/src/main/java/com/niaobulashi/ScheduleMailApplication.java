package com.niaobulashi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduleMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleMailApplication.class, args);
    }

}
