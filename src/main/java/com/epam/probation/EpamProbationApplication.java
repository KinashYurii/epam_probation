package com.epam.probation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EpamProbationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpamProbationApplication.class, args);
    }

}
