package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import sun.security.krb5.internal.ktab.KeyTab;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.app")
public class MyAppApplication implements CommandLineRunner {
    @Autowired
    CustomerRepository custo;
    @Autowired
    private JdbcTemplate jdbcTemplate ;
    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
//        customer_db customer = new  customer_db();
//        customer.setName("John Doe");
//        customer.setEmail("john@example.com");
//        custo.save(customer);
        List<customer_db> listCustomer = custo.findAll();
        listCustomer.forEach(System.out :: println);
    }
}