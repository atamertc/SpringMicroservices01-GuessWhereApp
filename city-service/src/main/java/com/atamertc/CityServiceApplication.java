
package com.atamertc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CityServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityServiceApplication.class, args);
    }
}