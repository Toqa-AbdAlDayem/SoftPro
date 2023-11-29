package StepDefinitions;

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

import java.util.logging.Logger;

public class ViewCustomer {
    @Autowired
    DataService dataService;
    DataForm dataForm=new DataForm();
    @Autowired
    private TestRestTemplate restTemplate;
    private WebDriver webDriver = null;
    Logger logger = Logger.getLogger(getClass().getName());
    @Given("the Admin is logged in")
    public void the_admin_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        String htmlContent = response.getBody();
        webDriver = new ChromeDriver();

        webDriver.get("data:text/html;charset=utf-8," + htmlContent);

        webDriver.findElement(By.id("user_name")).sendKeys("admin_user");
        webDriver.findElement(By.id("pass")).sendKeys("admin_password");
        sleep(200);

        webDriver.findElement(By.id("LogInBtn")).click();


        dataForm.setUserName( webDriver.findElement(By.id("user_name")).getAttribute("value"));
        dataForm.setPassword( webDriver.findElement(By.id("pass")).getAttribute("value"));

        String result=dataService.searchAccount(dataForm);
        if(result.equals("Admin")){
            assert(true);
            ResponseEntity<String> response1 = restTemplate.getForEntity("/home", String.class);
            Assertions.assertEquals(200, response1.getStatusCodeValue());
            String htmlContent1 = response1.getBody();
            //  driver = new ChromeDriver();
            webDriver.get("data:text/html;charset=utf-8," + htmlContent1);
            sleep(2000);}
    }

    @When("the Admin navigates to the {string} section")
    public void the_admin_navigates_to_the_section(String string) {
        WebElement viewCustomersLink = webDriver.findElement(By.linkText("View Customers"));
        viewCustomersLink.click();
    }

    @Then("the Admin should see a list of customer accounts")
    public void the_admin_should_see_a_list_of_customer_accounts() {
        ResponseEntity<String> response = restTemplate.getForEntity("/ViewCustomers", String.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        String htmlContent = response.getBody();
        webDriver = new ChromeDriver();

        webDriver.get("data:text/html;charset=utf-8," + htmlContent);
    }

    @When("selects a customer account to {string}")
    public void selects_a_customer_account_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement customerDetailsLink = webDriver.findElement(By.linkText("View Details"));
        customerDetailsLink.click();
    }

    @Then("the customer details should be displayed successfully")
    public void the_customer_details_should_be_displayed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        // Assuming there's an element on the customer details page
        WebElement customerDetailsElement = webDriver.findElement(By.id("customerDetails"));

        // Add assertions based on what you expect to see on the customer details page
        Assert.assertTrue(customerDetailsElement.isDisplayed());
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
