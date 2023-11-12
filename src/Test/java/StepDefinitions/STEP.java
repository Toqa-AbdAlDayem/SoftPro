package StepDefinitions;

import MyApp.User;
import MyApp.car;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class STEP {
    public car c=new car();
WebDriver driver=null;
boolean t=false;
    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
    driver= new ChromeDriver();
        driver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//signup.html");
        sleep(2000);
    }


    @And("they fill in the registration form with a valid username {string} and a strong password {string} and a correct email {string} and a correct confim password {string}")
    public void they_fill_in_the_registration_form_with_a_valid_username_and_a_strong_password_and_a_correct_email(String username, String password, String email,String conf) {
        System.out.println("iam in when");
      //  driver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//signup.html");


    driver.findElement(By.id("user_name")).sendKeys(username);
     driver.findElement(By.id("pass")).sendKeys(password);
     driver.findElement(By.id("email")).sendKeys(email);
     driver.findElement(By.id("conf")).sendKeys(conf);

       int z= 0;
       System.out.println(z);
        sleep(2000);

    }

    @Then("their account should be successfully created")
    public void their_account_should_be_successfully_created() {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        // Wait for the "name" element to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name")));

        int z=c.user.size();
        User u1=new User();
      for (int i=0;i<z;i++){
            System.out.println("jjj");
            User a =c.user.get(i);
            if (! (a.get_Name().equals(driver.findElement(By.id("user_name")).getText()))){
                u1.Set_name(driver.findElement(By.id("user_name")).getText());
                u1.Set_pass(driver.findElement(By.id("pass")).getText());
                u1.Set_email(driver.findElement(By.id("email")).getText());
                u1.Set_conf(driver.findElement(By.id("conf")).getText());
                t=true;
            }
            else {
                t=false;
            }
        }
        if (z==0){
            System.out.println(driver.findElement(By.id("user_name")).getText());
            u1.Set_name(driver.findElement(By.id("user_name")).getText());
            u1.Set_pass(driver.findElement(By.id("pass")).getText());
            u1.Set_email(driver.findElement(By.id("email")).getText());
            u1.Set_conf(driver.findElement(By.id("conf")).getText());
            t=true;

        }
        c.user.add(u1);
        System.out.println("my name"+c.user.get(0).get_Name());

    }
    @Then("they click the {string} button")
    public void they_click_the_button(String string) {

        driver.findElement(By.id("signup")).click();
        sleep(2000);

    }

    @Then("they should be redirected to the home page")
    public void they_should_be_redirected_to_the_home_page() {
       driver.get("C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//Home.html");

        sleep(2000);

        //driver.close();
       // driver.quit();

    }

    @And("they should see a welcome message")
    public void they_should_see_a_welcome_message() {
       System.out.println("hiiiiiiiiii");
    }


    @When("they fill in the registration form with a valid username {string} and a strong password {string} and a correct confim password {string}")
    public void they_fill_in_the_registration_form_with_a_valid_username_and_a_strong_password(String username, String password,String conf) {
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);

        driver.findElement(By.id("conf")).sendKeys(conf);

        sleep(2000);
    }

    @When("they leave the email")
    public void they_leave_the_email() {
        if (driver.findElement(By.id("email")).getText()==null){
            t=false;
        }

       assertFalse(t);
    }


    @Then("they should remain on the registration page")
    public void they_should_remain_on_the_registration_page() {

    }


    @When("they confirm the password with a different value {string}")
    public void they_confirm_the_password_with_a_different_value(String string) {
        if (! driver.findElement(By.id("pass")).getText().equals(driver.findElement(By.id("conf")).getText())){
            t=false;
        }

    }

    @Then("they should see a message indicating that the passwords do not match")
    public void they_should_see_a_message_indicating_that_the_passwords_do_not_match() {
    assertFalse(t);
    System.out.println("MISMATCH");
    }


    @Then("they should see the alert with message {string}")
    public void theyShouldSeeTheAlertWithMessage(String massege) {
        ((JavascriptExecutor) driver).executeScript("signUpError(arguments[0]);",massege);
        sleep(3000);
    }


    @When("they fill in the registration form with an exists username {string}")
    public void theyFillInTheRegistrationFormWithAnExistsUsername(String username) {
        driver.findElement(By.id("user_name")).sendKeys(username);
        sleep(200);
    }


    @Then("Then they should see the alert with message {string}")
    public void thenTheyShouldSeeTheAlertWithMessage(String massege) {
        ((JavascriptExecutor) driver).executeScript("signUpError(arguments[0]);",massege);
        sleep(3000);
    }

    private void displayErrorAlert(String message) {
        Alert errorAlert = driver.switchTo().alert();
        assertEquals(message, errorAlert.getText());
        errorAlert.accept();
    }

    @When("they fill in the registration form with a valid username {string} and a strong password {string}")
    public void theyFillInTheRegistrationFormWithAValidUsernameAndAStrongPassword(String username, String password){
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);


        sleep(2000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println("Erooooooooooooooooooooor");
        }
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }


    }}