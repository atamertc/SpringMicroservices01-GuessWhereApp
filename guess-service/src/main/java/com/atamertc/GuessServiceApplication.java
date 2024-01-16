
package com.atamertc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GuessServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuessServiceApplication.class, args);
    }
}