package com.ermankurtay.assignment10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.ermankurtay.assignment10")
public class Assignment10Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment10Application.class, args);
    }

}