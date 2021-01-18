package com.epam.probation.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;


//@Configuration
//@PropertySource({"classpath:maria.properties"})
//@EnableJpaRepositories(
//        basePackages = "com.epam.probation.DAO.author",
//        entityManagerFactoryRef = "authorEntityManager",
//        transactionManagerRef = "authorTransactionManager")
public class AuthorPersistenceConf {

    @Bean
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource authorDataSource() {
        return DataSourceBuilder.create()
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean authorEntityManager(EntityManagerFactoryBuilder builder) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder
                .dataSource(authorDataSource())
                .packages("com.epam.probation.model.entity")
                .persistenceUnit("external")
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager authorTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(authorDataSource());
        transactionManager.setPersistenceUnitName("external");
        return transactionManager;
    }
}
