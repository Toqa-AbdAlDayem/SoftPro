
package StepDefinitions;


import java.util.logging.Logger;

import com.app.customer.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LogInSteps {
    @Autowired
    private TestRestTemplate restTemplate;
    Logger logger = Logger.getLogger(getClass().getName());
    private WebDriver webDriver = null;
    private DataForm data = new DataForm();
    @Autowired
    private DataService dataService;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private ErrorMessageRepository errorMessageRepository;

    private String expectedErrorMessage;
    private String actualErrorMessage;

    @Given("the app is running")
    public void the_app_is_running() {
        webDriver =new ChromeDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        // Verify the response status if needed
        Assertions.assertEquals(200, response.getStatusCodeValue());
        // Get the HTML content from the response body
        String htmlContent = response.getBody();
        // Use the HTML content or parse it as needed
        // ...
        // Create your webDriver and navigate as needed
        logger.info("HTML Content: " + htmlContent);
        webDriver = new ChromeDriver();
        webDriver.get("data:text/html;charset=utf-8," + htmlContent);

    }
    @When("I enter my admin username {string} and password {string}")
    public void i_enter_my_admin_username_and_password(String name, String pass) {

        webDriver.findElement(By.id("user_name")).sendKeys(name);
        webDriver.findElement(By.id("pass")).sendKeys(pass);
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
        webDriver.findElement(By.id(string)).click();
    }

    @Then("I should be redirected to the admin dashboard")
    public void i_should_be_redirected_to_the_admin_dashboard() {



        data.setUserName(webDriver.findElement(By.id("user_name")).getAttribute("value"));
        data.setPassword((webDriver.findElement(By.id("pass")).getAttribute("value")));
        String result = customerController.LogInFunc(data);
        if (result.equals("Admin")) {
            assertTrue(true);
            ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

            // Verify the response status if needed
            Assertions.assertEquals(200, response.getStatusCodeValue());

            // Get the HTML content from the response body
            String htmlContent = response.getBody();

            // Use the HTML content or parse it as needed
            // ...

            // Create your webDriver and navigate as needed
            logger.info("HTML Content: " + htmlContent);
            webDriver = new ChromeDriver();
            webDriver.get("data:text/html;charset=utf-8," + htmlContent);
        }
        sleep(2000);
        webDriver.close();
        webDriver.quit();

    }

    @When("I enter my customer username {string} and password {string}")
    public void i_enter_my_customer_username_and_password(String name, String pass) {
        webDriver.findElement(By.id("user_name")).sendKeys(name);
        webDriver.findElement(By.id("pass")).sendKeys(pass);
        sleep(2000);
    }


    @Then("I should be redirected to the customer dashboard")
    public void i_should_be_redirected_to_the_customer_dashboard() {
        webDriver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Customer.html");
        sleep(200);
        webDriver.close();
        webDriver.quit();
    }

    @When("I enter my installer username {string} and password {string}")
    public void i_enter_my_installer_username_and_password(String name, String pass) {
        webDriver.findElement(By.id("user_name")).sendKeys(name);
        webDriver.findElement(By.id("pass")).sendKeys(pass);
        sleep(200);
    }

    @Then("I should be redirected to the installer dashboard")
    public void i_should_be_redirected_to_the_installer_dashboard() {
        webDriver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Installer.html");
        sleep(200);
        webDriver.close();
        webDriver.quit();
    }



    @When("I enter an invalid username {string} and password {string}")
    public void i_enter_an_invalid_username_and_password(String name, String pass) {
        webDriver.findElement(By.id("user_name")).sendKeys(name);
        webDriver.findElement(By.id("pass")).sendKeys(pass);
        sleep(200);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        this.expectedErrorMessage = expectedErrorMessage;
        ErrorMessage errorMessageEntity = errorMessageRepository.findByMessage(expectedErrorMessage);
        this.actualErrorMessage = errorMessageEntity.getMessage();

        // Perform assertion to check if the actual error message matches the expected error message
        assertEquals(expectedErrorMessage, actualErrorMessage);



        webDriver.close();
        webDriver.quit();
    }

}

