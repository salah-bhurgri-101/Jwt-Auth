package com.codemyth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthenticationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationExampleApplication.class, args);
        System.out.println("Jwt Project Started...");
    }
}
