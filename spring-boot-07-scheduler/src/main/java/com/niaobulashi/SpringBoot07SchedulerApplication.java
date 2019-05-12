package com.niaobulashi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot07SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot07SchedulerApplication.class, args);
	}

}
