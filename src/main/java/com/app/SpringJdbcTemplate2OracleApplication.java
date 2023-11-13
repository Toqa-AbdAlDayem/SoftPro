package com.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringJdbcTemplate2OracleApplication (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

System.out.println("hu");
    }

}