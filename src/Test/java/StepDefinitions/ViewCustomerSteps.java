package StepDefinitions;

import com.app.customer.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.ui.Model;

import java.util.logging.Logger;

public class ViewCustomerSteps {
    @Autowired
    DataService dataService;
    DataForm dataForm=new DataForm();
    @Autowired
    private TestRestTemplate restTemplate;
    CustomerController customerController ;
    private WebDriver webDriver = null;
    Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    Model model;
    LogInSteps logInSteps=new LogInSteps();
    private CustomerRepository customerRepository;
    private  int customerId ;
    private String NewName;
    private String OldName;

    @Given("the Admin is logged in")
    public void the_admin_is_logged_in() {
        logInSteps.i_am_on_the_login_page();
        logInSteps.i_enter_my_admin_username_and_password("eman","555");
        logInSteps.i_click_the_button("LogInBtn");
        logInSteps.i_should_be_redirected_to_the_admin_dashboard();
        sleep(2000);

    }

    @When("the Admin navigates to the {string} section")
    public void the_admin_navigates_to_the_section(String string) {
        WebElement customerDetailsLink = webDriver.findElement(By.linkText(string));
        customerDetailsLink.click();
        webDriver.get("http://localhost:"+CucumberIT.getPort()+"/ViewCustomers");
        sleep(3000);
    }

    @Then("the Admin should see a list of customer accounts")
    public void the_admin_should_see_a_list_of_customer_accounts() {
        String expectedUrl = "http://localhost:"+CucumberIT.getPort()+"/ViewCustomers";
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);

// Check if the title matches
//        String expectedTitle = "Expected Page Title";
//        String currentTitle = webDriver.getTitle();
//        Assert.assertEquals(currentTitle, expectedTitle);
        webDriver.quit();
    }


    @When("selects a customer account to {string}")
    public void selects_a_customer_account_to(String string){
        String[] customerName = string.split(" ");
        CustomerDb customer = customerRepository.findByName(customerName[1]);

        // Extract the customer ID from the database
        customerId = customer.getId();

        // Continue with the rest of your code
        WebElement customerDetailsLink = webDriver.findElement(By.linkText(string));
        customerDetailsLink.click();

        customerController.showCustomerDetails(Long.valueOf(customerId), model);
        webDriver.get("http://localhost:" + CucumberIT.getPort() + "/customers/" + customerId);
        sleep(3000);
//
//
//        WebElement customerDetailsLink = webDriver.findElement(By.linkText(string));
//        customerDetailsLink.click();
//        customerController.showCustomerDetails(Long.valueOf(string2),model);
//        webDriver.get("http://localhost:"+CucumberIT.getPort()+"//customers/"+string2);
//        sleep(3000);
    }


    @Then("the customer details should be displayed successfully")
    public void the_customer_details_should_be_displayed_successfully() {
        String expectedUrl = "http://localhost:"+CucumberIT.getPort()+"//customers/"+customerId;
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
        OldName=getTextFromNameField("name");
    }


    @When("edit the {string} value to {string}")
    public void edit_the_value_to(String name, String newName) {
        NewName=newName;
        webDriver.findElement(By.id(name)).sendKeys(newName);

    }

    @When("Click on {string} button")
    public void click_on_button(String button) {
        WebElement customerDetailsLink = webDriver.findElement(By.linkText(button));
        customerDetailsLink.click();


    }

    @Then("the customer account should be edited successfully")
    public void the_customer_account_should_be_edited_successfully() {
        String  updatedName = getTextFromNameField("name");

        // The expected name you provided in the previous step
        String expectedName = NewName; // Replace with the actual expected name

        // Assert that the updated name matches the expected name
        Assertions.assertEquals(expectedName, updatedName, "The customer account was not edited successfully");
    }
    @Then("the customer account should not be change")
    public void the_customer_account_should_not_be_change() {
        String  updatedName = getTextFromNameField("name");

        // The expected name you provided in the previous step
        String expectedName = OldName; // Replace with the actual expected name

        // Assert that the updated name matches the expected name
        Assertions.assertEquals(expectedName, updatedName, "The customer account was not edited successfully");
    }

    private String getTextFromNameField(String FieldId) {
        WebElement nameField = webDriver.findElement(By.id(FieldId)); // Replace "id" with the actual identifier of your name textfield
        return nameField.getAttribute("value");
    }
    private  void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

            logger.info("Erooooooooooooooooooooor");
        }
    }
}
