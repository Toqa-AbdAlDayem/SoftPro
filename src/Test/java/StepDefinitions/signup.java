package StepDefinitions;

import com.app.CustomerController;
import com.app.CustomerRepository;
import com.app.DataForm;
import com.app.DataService;
import io.cucumber.java.en.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class signup{

    private WebDriver webDriver =null;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private DataForm data =new DataForm();
    @Mock
    private CustomerRepository repository;
    @Mock
    private DataService dataService =new DataService(repository);

    @InjectMocks
    private CustomerController customerController;



    @Given("the user is on the registration page")
    public void givenTheUserIsOnTheRegistrationPage() {
        webDriver= new ChromeDriver();
        webDriver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//templates//signup.html");
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
      //  data.setUserId(Integer.parseInt(webDriver.findElement(By.id("user_id")).getAttribute("value")));
        data.setUserName(webDriver.findElement(By.id("user_name")).getAttribute("value"));
        data.setPassword((webDriver.findElement(By.id("pass")).getAttribute("value")));
        data.setConfirmPassword(webDriver.findElement(By.id("conf")).getAttribute("value"));
        data.setEmail(webDriver.findElement(By.id("email")).getAttribute("value"));
       // data.setBirthDate(webDriver.findElement(By.id("birth")).getAttribute("value"));
        data.setGender(webDriver.findElement(By.id("gender")).getAttribute("value"));


        Mockito.when(dataService.createAccount(data)).thenReturn(true);
        boolean isSucsess= dataService.createAccount(data);
        String result = customerController.signUp(data);
        if(isSucsess){

            webDriver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//templates//Home.html");
        }

       boolean isSucsess2=result.equals("Home");
        assertTrue(isSucsess2);

    }

    @And("they should be redirected to the home page")
    public void andTheyShouldBeRedirectedToTheHomePage() {
        // Implement verification logic using Selenium
        Assertions.assertEquals("Home Page", webDriver.getTitle()); // Replace with your actual home page title
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println("Erooooooooooooooooooooor");
        }
    }
}
