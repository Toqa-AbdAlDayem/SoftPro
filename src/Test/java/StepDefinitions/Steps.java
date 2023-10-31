package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import static org.junit.Assert.assertTrue;
public class Steps {


}
/*
public class Steps {

boolean t=false;

    WebDriver driver = null;
    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
       WebDriver driver =new ChromeDriver();
       driver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//signup.html");
    }


    @When("they fill in the registration form with a valid username {string} and a strong password {string} and a correct email {string}\"")
    public void they_fill_in_the_registration_form_with_a_valid_username_and_a_strong_password_and_a_correct_email() {
         classes.User u1=new classes.User();
        u1.Set_name(driver.findElement(By.id("user_name")).getText());
        u1.Set_pass(driver.findElement(By.id("pass")).getText());
        u1.Set_email(driver.findElement(By.id("email")).getText());
        u1.Set_conf(driver.findElement(By.id("conf")).getText());
        classes.car c=new classes.car();
        c.user.add(u1);
        t=true;

    }

    @When("they click the {string} button")
    public void they_click_the_button(String string) {
        driver.findElement(By.id("signup")).click();

    }

    @Then("they should be redirected to the home page")
    public void they_should_be_redirected_to_the_home_page() {
        driver.navigate().to("Google.com");

    }

    @Then("they should see a welcome message")
    public void they_should_see_a_welcome_message() {
        driver.get("http://example.com");
        String message = "Hello, this is a Selenium-generated message!";
        JOptionPane.showMessageDialog(null,message);

    }

    @Then("their account should be successfully created")
    public void their_account_should_be_successfully_created() {
       assertTrue(t);


    }

    @When("they fill in the registration form with a valid username {string} and a strong password {string}")
    public void they_fill_in_the_registration_form_with_a_valid_username_and_a_strong_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("they leave the email")
    public void they_leave_the_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("they should see a message indicating that the email is required")
    public void they_should_see_a_message_indicating_that_the_email_is_required() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("they should remain on the registration page")
    public void they_should_remain_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("they fill in the registration form with an exists username {string}")
    public void they_fill_in_the_registration_form_with_an_exists_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("they should see a message indicating that the username is exist")
    public void they_should_see_a_message_indicating_that_the_username_is_exist() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("they confirm the password with a different value {string}")
    public void they_confirm_the_password_with_a_different_value(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("they should see a message indicating that the passwords do not match")
    public void they_should_see_a_message_indicating_that_the_passwords_do_not_match() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }}
*/



