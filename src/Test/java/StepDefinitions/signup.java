package StepDefinitions;

import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import com.app.customer.DataForm;
import com.app.customer.DataService;
import com.app.customer.CustomerController;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import io.cucumber.java.en.Given;

import java.net.ConnectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;

public class signup {
    @Autowired
    private TestRestTemplate restTemplate;
    Logger logger = Logger.getLogger(getClass().getName());
    private WebDriver webDriver = null;
    private DataForm data = new DataForm();
    @Autowired
    private DataService dataService;
    @Autowired
    private CustomerController customerController;


    @Given("the user is on the registration page")
    public void givenTheUserIsOnTheRegistrationPage() throws ConnectException {
        ResponseEntity<String> response = restTemplate.getForEntity("/form", String.class);

        // Verify the response status if needed
        Assertions.assertEquals(200, response.getStatusCodeValue());

        // Get the HTML content from the response body
        String htmlContent = response.getBody();

        // Use the HTML content or parse it as needed
        // ...

        // Create your webDriver and navigate as needed
        webDriver = new ChromeDriver();
        webDriver.get("data:text/html;charset=utf-8," + htmlContent);

    }

    @When("they fill in the registration form with a valid username {string} and a strong password {string} and a correct confirmpass {string} and a correct email {string} and Birthdate {string} and Gender {string}")
    public void theyFillInTheRegistrationFormWithAValidUsernameAndAStrongPasswordAndACorrectConfirmpassAndACorrectEmailAndBirthdateAndGender(String username, String password, String confirmPassword, String email, String birthDate, String gender) {
        WebElement usernameField = webDriver.findElement(By.id("user_name"));
        usernameField.sendKeys(username);

        WebElement passwordField = webDriver.findElement(By.id("pass"));
        passwordField.sendKeys(password);

        WebElement confirmPasswordField = webDriver.findElement(By.id("conf"));
        confirmPasswordField.sendKeys(confirmPassword);

        WebElement emailField = webDriver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement dateField = webDriver.findElement(By.id("birth"));
        dateField.sendKeys(birthDate);

        WebElement genderField = webDriver.findElement(By.id("gender"));
        genderField.sendKeys(gender);

        sleep(2000);
    }

    @And("they click the {string} button")
    public void andTheyClickTheButton(String button) {
        WebElement signUpButton = webDriver.findElement(By.id("signup"));
        signUpButton.click();
    }

    @Then("their account should be successfully created")
    public void thenTheirAccountShouldBeSuccessfullyCreated() throws ParseException {
        String pattern = "mm-dd-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        data.setUserName(webDriver.findElement(By.id("user_name")).getAttribute("value"));
        data.setPassword((webDriver.findElement(By.id("pass")).getAttribute("value")));
        data.setConfirmPassword(webDriver.findElement(By.id("conf")).getAttribute("value"));
        data.setEmail(webDriver.findElement(By.id("email")).getAttribute("value"));
        data.setGender(webDriver.findElement(By.id("gender")).getAttribute("value"));

        CustomerDb dataEntity = new CustomerDb();
        String result = customerController.signUp(data);
        //String isSuccess = dataService.createAccount(data, dataEntity);
System.out.println("hhhhh"+result);
     //   boolean isSuccess2 = result.equals("Home");

        if (result.equals("Home")) {
            assertTrue(true);
            ResponseEntity<String> response = restTemplate.getForEntity("/home", String.class);

            // Verify the response status if needed
            Assertions.assertEquals(200, response.getStatusCodeValue());

            // Get the HTML content from the response body
            String htmlContent = response.getBody();

            // Use the HTML content or parse it as needed
            // ...

            // Create your webDriver and navigate as needed
            webDriver = new ChromeDriver();
            webDriver.get("data:text/html;charset=utf-8," + htmlContent);
        }
    }

    @And("they should be redirected to the home page")
    public void andTheyShouldBeRedirectedToTheHomePage() {
        Assertions.assertEquals("Home page", webDriver.getTitle());
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            logger.info("Error during sleep");
        }
    }

    @When("they fill in the registration form with an exists username {string}")
    public void theyFillInTheRegistrationFormWithAnExistsUsername(String arg0) {
        data.setUserName(webDriver.findElement(By.id("user_name")).getAttribute("value"));
    }
}
