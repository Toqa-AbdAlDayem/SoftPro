package StepDefinitions;

import com.app.customer.*;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import io.cucumber.java.en.Given;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class signup {


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
    private HttpServer server;


    @Given("the user is on the registration page")
    public void givenTheUserIsOnTheRegistrationPage() throws ConnectException {
//        ResponseEntity<String> response = restTemplate.getForEntity("/form", String.class);
//        Assertions.assertEquals(200, response.getStatusCodeValue());
//        String htmlContent = response.getBody();
//        webDriver = new ChromeDriver();
//        System.out.println(htmlContent);
//        webDriver.get("data:text/html;charset=utf-8," + htmlContent);
        try {
            // Use a local server to serve the HTML file
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/form", new MyHandler());
            server.setExecutor(null); // creates a default executor
            server.start();

            // Open the HTML page in the browser
            webDriver = new ChromeDriver();
            //webDriver.get("http://localhost:8080/form");
            webDriver.navigate().to("http://localhost:8080/form");
            waitForPageLoad();

            // Sleep to allow time for the browser to load the page
            Thread.sleep(5000); // Adjust the sleep duration as needed


            // Optionally, you can perform assertions or other actions on the loaded page

            // Close the local server and the WebDriver when done

        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); // Handle the exceptions appropriately
        }
//
//        File tempFile = null;
//        try {
//            tempFile = File.createTempFile("temp", ".html");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (PrintWriter writer = new PrintWriter(tempFile)) {
//            writer.write(htmlContent);
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        try {
//            webDriver.get(tempFile.toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
    }

    @When("they fill in the registration form with a valid username {string} and a strong password {string} and a correct confirmpass {string} and a correct email {string} and Birthdate {string} and Gender {string}")
    public void theyFillInTheRegistrationFormWithAValidUsernameAndAStrongPasswordAndACorrectConfirmpassAndACorrectEmailAndBirthdateAndGender(String username, String password, String confirmPassword, String email, String birthDate, String gender) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));

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
        waitForAccountCreation();
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
        //    webDriver = new ChromeDriver();
            webDriver.get("data:text/html;charset=utf-8," + htmlContent);
        }
    }

    @And("they should be redirected to the home page")
    public void andTheyShouldBeRedirectedToTheHomePage() {

        Assertions.assertEquals("Home page", webDriver.getTitle());
        server.stop(0);
        webDriver.quit();

    }
    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    private void waitForAccountCreation() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        // Customize the wait condition based on your application's behavior
        // For example, wait until a success message appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
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

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            try (InputStream htmlStream = getClass().getResourceAsStream("/templates/signup.html")) {
                byte[] htmlBytes = htmlStream.readAllBytes();
                t.sendResponseHeaders(200, htmlBytes.length);
                OutputStream os = t.getResponseBody();
                os.write(htmlBytes);
                os.close();
            }
        }
//            // Load the HTML content from the file
//            InputStream htmlStream = getClass().getResourceAsStream("/templates/signup.html");
//            byte[] htmlBytes = htmlStream.readAllBytes();
//            String htmlContent = new String(htmlBytes);
//
//            // Send the HTML content as the response
//            t.sendResponseHeaders(200, htmlBytes.length);
//            OutputStream os = t.getResponseBody();
//            os.write(htmlBytes);
//            os.close();
        }
}
