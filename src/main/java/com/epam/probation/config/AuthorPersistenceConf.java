//package com.epam.probation.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.epam.probation.DAO",
//        entityManagerFactoryRef = "authorEntityManager",
//        transactionManagerRef = "authorTransactionManager")
//public class AuthorPersistenceConf {
//
//    @Autowired
//    private final Environment env;
//
//    public AuthorPersistenceConf(Environment env) {
//        this.env = env;
//    }
//
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.second-datasource")
//    public DataSource productDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean authorEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(productDataSource());
//        em.setPackagesToScan("com.epam.probation.model");
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("spring.jpa.hibernate.ddl-auto",
//                env.getProperty("spring.jpa.hibernate.ddl-auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("hibernate.second-dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager authorTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                authorEntityManager().getObject());
//        return transactionManager;
//    }
//}
