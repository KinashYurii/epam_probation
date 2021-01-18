package com.epam.probation;

import com.epam.probation.configuration.property.ExceptionProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(ExceptionProperties.class)
public class EpamProbationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpamProbationApplication.class, args);
    }

}
