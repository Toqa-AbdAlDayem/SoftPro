//package com.app;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import java.sql.Date;
//@RestController
//@RequestMapping("/api")
//public class SignupController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @GetMapping("/openPage")
//    public String openPage() {
//        return "signup"; // This assumes there's an HTML file named "signup.html" in the "resources/templates" directory
//    }
//
//    @PostMapping("/newSign")
//    public String newSign() {
//        System.out.println("Inside newSign method");
//        try {
//            int custId = 12345;
//            String name = "toqa";
//            String password = "12345";
//            String confirmPassword = "12345";
//            String email = "toqaomar24@gmail.com";
//            // Date birthdate = Date.valueOf(driver.findElement(By.id("birth")).getAttribute("value"));
//            String gender = "Male";
//
//            String query = "INSERT INTO customer (CUST_ID, NAME, PASS, CONF_PASS, EMAIL, GENDER) VALUES (?, ?, ?, ?, ?, ?)";
//            jdbcTemplate.update(query, custId, name, password, confirmPassword, email, gender);
//
//            return "Data saved successfully";
//
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            return "Error saving data to the database: " + e.getMessage();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Unexpected error: " + e.getMessage();
//        }
//    }
//}
