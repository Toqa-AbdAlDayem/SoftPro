package StepDefinitions;


import java.util.logging.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class LogInSteps {

    Logger logger = Logger.getLogger(getClass().getName());
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

       logger.info(" ");

        driver.close();
        driver.quit();
    }



}
