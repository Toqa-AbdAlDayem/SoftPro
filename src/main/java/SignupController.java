

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Date;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Inject WebDriver instance (you need to set up WebDriver injection, perhaps using @Autowired)
    @Autowired
    private WebDriver driver;

    @PostMapping("/newSign")
    public String newSign() {
        try {
            int custId = Integer.parseInt(driver.findElement(By.id("user_id")).getText());
            String name = driver.findElement(By.id("user_name")).getText();
            String password = driver.findElement(By.id("pass")).getText();
            String confirmPassword = driver.findElement(By.id("conf")).getText();
            String email = driver.findElement(By.id("email")).getText();
            Date birthdate = Date.valueOf(driver.findElement(By.id("birth")).getText());
            String gender = driver.findElement(By.id("gender")).getText();

            String query = "INSERT INTO customer (CUST_ID, NAME, PASS, CONF_PASS, EMAIL, BIRTHDATE, GENDER) VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, custId, name, password, confirmPassword, email, birthdate, gender);

            return "Data saved successfully";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}


