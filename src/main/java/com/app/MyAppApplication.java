package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import java.util.List;

@SpringBootApplication
public class MyAppApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate ;
    public static void main(String[] args) {


        SpringApplication.run(MyAppApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql="select * from customer";
        List<customer_db> customer_list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(customer_db.class)) ;
        customer_list.forEach(System.out :: println);
    }
}
