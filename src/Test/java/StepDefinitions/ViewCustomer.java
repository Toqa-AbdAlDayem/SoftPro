package StepDefinitions;

import com.app.customer.CustomerController;
import com.app.customer.DataForm;
import com.app.customer.DataService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.logging.Logger;

public class ViewCustomer {
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
    @Given("the Admin is logged in")
    public void the_admin_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:"+CucumberIT.getPort()+"/");

        webDriver.findElement(By.id("user_name")).sendKeys("eman");
        webDriver.findElement(By.id("pass")).sendKeys("555");
        sleep(200);

        dataForm.setUserName( webDriver.findElement(By.id("user_name")).getAttribute("value"));
        dataForm.setPassword( webDriver.findElement(By.id("pass")).getAttribute("value"));

        webDriver.findElement(By.id("LogInBtn")).click();

        String result=dataService.searchAccount(dataForm);
        if(result.equals("Admin")){
            webDriver.get("http://localhost:"+CucumberIT.getPort()+"/home");

            sleep(2000);}
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


    @When("selects a customer account to {string} with ID {string}")
    public void selects_a_customer_account_to_with_id(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        WebElement customerDetailsLink = webDriver.findElement(By.linkText(string));
        customerDetailsLink.click();
        customerController.showCustomerDetails(Long.valueOf(string2),model);
        webDriver.get("http://localhost:"+CucumberIT.getPort()+"//customers/"+string2);
        sleep(3000);
    }


    @Then("the customer details should be displayed successfully")
    public void the_customer_details_should_be_displayed_successfully() {
        String expectedUrl = "http://localhost:"+CucumberIT.getPort()+"//customers/2";
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }


    //    @When("selects a customer account to {string}")
//    public void selects_a_customer_account_to(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("confirms the {string}")
//    public void confirms_the(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the customer account should be deactivated successfully")
//    public void the_customer_account_should_be_deactivated_successfully() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("cancel the {string}")
//    public void cancel_the(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
    private  void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

            logger.info("Erooooooooooooooooooooor");
        }
    }
}
