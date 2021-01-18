package com.epam.probation.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

//@Configuration
//@PropertySource({"classpath:postgres.properties"})
//@EnableJpaRepositories(
//        basePackages = "com.epam.probation.DAO.book",
//        entityManagerFactoryRef = "bookEntityManager",
//        transactionManagerRef = "bookTransactionManager")
public class BookPersistenceConf {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create()
                .build();
    }


    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean bookEntityManager(EntityManagerFactoryBuilder builder) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder
                .dataSource(bookDataSource())
                .packages("com.epam.probation.model.entity")
                .persistenceUnit("internal")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager bookTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(bookDataSource());
        transactionManager.setPersistenceUnitName("internal");
        return transactionManager;
    }
}
