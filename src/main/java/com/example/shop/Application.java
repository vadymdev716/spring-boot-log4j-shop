package com.example.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(com.example.shop.Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Test log");
    }
}
