package com.lhb.lhbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class LhBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(LhBackendApplication.class, args);
    }
}
