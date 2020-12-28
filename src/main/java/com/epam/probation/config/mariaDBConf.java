package com.epam.probation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class mariaDBConf {

//    @Bean
//    public DriverManagerDataSource mariaDBConfig() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setPassword("root");
//        dataSource.setUsername("root");
//        dataSource.setUrl("jdbc:mariadb://localhost:3307/probation");
//        return dataSource;
//    }
}

//spring.datasource.url=jdbc:mariadb://127.0.0.1:3307/probation
//        spring.datasource.username=root
//        spring.datasource.password=root
//        #spring.datasource.driver-class-name=org.mariadb.jdbc.Driver