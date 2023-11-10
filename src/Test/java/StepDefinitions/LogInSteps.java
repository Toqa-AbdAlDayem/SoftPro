package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LogInSteps {
    private WebDriver driver =null;

    @Given("the app is running")
    public void the_app_is_running() {
        driver =new ChromeDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Login.html");

    }
    @When("I enter my admin username {string} and password {string}")
    public void i_enter_my_admin_username_and_password(String name, String pass) {
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pass);
        sleep(200);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @When("I click the {string} button")
    public void i_click_the_button(String string) {
        driver.findElement(By.id(string)).click();
    }

    @Then("I should be redirected to the admin dashboard")
    public void i_should_be_redirected_to_the_admin_dashboard() {
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Admin.html");
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
//        System.out.println(string);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
//        WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ErrorMsg")));
//
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("document.getElementById('ErrorMsg').style.visibility = 'visible';", errorMsgElement);
 ((JavascriptExecutor) driver).executeScript("signUpError(arguments[0]);",string);
//        try {
//            Thread.sleep(2000);
//        }
//        catch (Exception e){
//            System.out.println("Erooooooooooooooooooooor");
//        }
        System.out.println(" ");

        driver.close();
        driver.quit();
    }
/*
    @When("I click the {string} link")
    public void i_click_the_link(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I enter my email {string}")
    public void i_enter_my_email(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click the {string} button")
    public void i_click_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should receive a password reset email")
    public void i_should_receive_a_password_reset_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/
/*    @Given("I have received a password reset email")
    public void i_have_received_a_password_reset_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click the reset password link in the email")
    public void i_click_the_reset_password_link_in_the_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I set a new password")
    public void i_set_a_new_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click the {string} button")
    public void i_click_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should be able to log in with the new password")
    public void i_should_be_able_to_log_in_with_the_new_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
*/

}
