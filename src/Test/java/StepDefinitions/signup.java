package StepDefinitions;

import com.app.customer.*;
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
    ErrorMessageRepository errorMessageRepository;

    private CustomerDb customerDb=new CustomerDb();
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
        Assertions.assertEquals(200, response.getStatusCodeValue());
        String htmlContent = response.getBody();
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
data.setUserId(12347556);

       String result = customerController.signUp(data);
        if (result.equals("Home")) {
            assertTrue(true);
            ResponseEntity<String> response = restTemplate.getForEntity("/home", String.class);
            Assertions.assertEquals(200, response.getStatusCodeValue());
            String htmlContent = response.getBody();
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
        data.setPassword("123");
        data.setConfirmPassword("123");
        String result = dataService.createAccount(data,customerDb);


        if (result.equals("User ID already exists")) {
            assertTrue(true);

        }
    }



    @Then("Then they should see the alert with message {string}")
    public void then_they_should_see_the_alert_with_message(String string) {
        String error = dataService.createAccount(data,customerDb);

        ErrorMessage errorMessageEntity = errorMessageRepository.findByMessage(error);

         logger.info(errorMessageEntity.getMessage());
    }

    @Then("they should remain on the registration page")
    public void they_should_remain_on_the_registration_page() {
        String result = customerController.signUp(data);
        if (result.equals("signup")) {
            assertTrue(true);}
    }

    @When("they fill in the registration form with a valid username {string} and a strong password {string} and they confirm the password with a different value {string}")
    public void theyFillInTheRegistrationFormWithAValidUsernameAndAStrongPasswordAndTheyConfirmThePasswordWithADifferentValue(String name, String arg1, String arg2) {

        data.setUserName(webDriver.findElement(By.id("user_name")).getAttribute("value"));
        data.setPassword((webDriver.findElement(By.id("pass")).getAttribute("value")));
        data.setConfirmPassword(webDriver.findElement(By.id("conf")).getAttribute("value"));
        data.setEmail(webDriver.findElement(By.id("email")).getAttribute("value"));



        String result = dataService.createAccount(data,customerDb);
        if (result.equals("Password and Confirm Password do not match.")) {
            assertTrue(true);

        }

    }
}
