package com.app.customer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = {CustomerRepository.class, AppointmenRepository.class})
@ComponentScan(basePackages = {"com.app.customer","StepDefinitions"})
public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {




 private final MongoTemplate mongoTemplate;
    @Autowired
    public SpringJdbcTemplate2OracleApplication ( MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

System.out.println("hu");
    }

}