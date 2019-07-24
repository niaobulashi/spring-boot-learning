package com.niaobulashi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niaobulashi.mapper")
public class ShiroRememberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroRememberApplication.class, args);
    }

}
