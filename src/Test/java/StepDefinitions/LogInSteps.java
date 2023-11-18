/*
package StepDefinitions;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;

import com.app.customer.SpringJdbcTemplate2OracleApplication;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class LogInSteps {
    private static HttpClient httpClient = HttpClient.newHttpClient();
    Logger logger = Logger.getLogger(getClass().getName());
    private WebDriver driver =null;
    private static void waitForApplicationToStart() {
        // Define the URL of an endpoint or a health check
        System.out.println("Waiting for the application to start...");

        // Adjust the URL based on your health endpoint configuration
        String healthCheckUrl = "http://localhost:8080/actuator/health";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(healthCheckUrl))
                .GET()
                .build();

        int maxAttempts = 30; // Increase or decrease based on your needs
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    System.out.println("Application started successfully!");
                    return;
                }
            } catch (IOException | InterruptedException e) {
                // Log the exception if needed
                e.printStackTrace();
            }

            attempts++;
            System.out.println("Attempt " + attempts + ": Waiting for the application...");
            try {
                Thread.sleep(1000); // Adjust the delay based on your needs
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Timeout waiting for application to start.");

    }
    @BeforeAll
    public static void startSpringBootApplication() {
        // Programmatically start your Spring Boot application
        Thread springBootThread = new Thread(() -> SpringJdbcTemplate2OracleApplication.main(new String[]{}));
        springBootThread.start();

        // Optionally, add a delay to allow the Spring Boot application to start
        try {
            Thread.sleep(5000); // Adjust the delay based on your application's startup time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForApplicationToStart();
    }

    @Given("the app is running")
    public void the_app_is_running() {
        driver =new ChromeDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Before navigating to http://localhost:8080/");
        driver.get("http://localhost:8080");
        System.out.println("After navigating to http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/"));
//        System.out.println("Afterrrrrr navigating to http://localhost:8080/");


    }
    @When("I enter my admin username {string} and password {string}")
    public void i_enter_my_admin_username_and_password(String name, String pass) {
        driver.findElement(By.id("user_name")).sendKeys(name);
        driver.findElement(By.id("pass")).sendKeys(pass);
        sleep(200);
    }

    private  void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

            logger.info("Erooooooooooooooooooooor");
        }
    }

    @When("I click the {string} button")
    public void i_click_the_button(String string) {
        driver.findElement(By.id(string)).click();
    }

    @Then("I should be redirected to the admin dashboard")
    public void i_should_be_redirected_to_the_admin_dashboard() {
       // driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Admin.html");
        sleep(2000);
        driver.close();
        driver.quit();

    }

    @When("I enter my customer username {string} and password {string}")
    public void i_enter_my_customer_username_and_password(String name, String pass) {
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pass);
        sleep(2000);
    }


    @Then("I should be redirected to the customer dashboard")
    public void i_should_be_redirected_to_the_customer_dashboard() {
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Customer.html");
        sleep(200);
        driver.close();
        driver.quit();
    }

    @When("I enter my installer username {string} and password {string}")
    public void i_enter_my_installer_username_and_password(String name, String pass) {
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pass);
        sleep(200);
    }

    @Then("I should be redirected to the installer dashboard")
    public void i_should_be_redirected_to_the_installer_dashboard() {
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Installer.html");
        sleep(200);
        driver.close();
        driver.quit();
    }



    @When("I enter an invalid username {string} and password {string}")
    public void i_enter_an_invalid_username_and_password(String name, String pass) {
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pass);
        sleep(200);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String string) {

       logger.info(" ");

        driver.close();
        driver.quit();
    }



}
*/
