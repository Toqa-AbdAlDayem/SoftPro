package com.app.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app.customer", "StepDefinitions"})
public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application is running.");
        // Your code logic goes here
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
