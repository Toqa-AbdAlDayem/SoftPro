package StepDefinitions;

import com.app.ManegerAndProduct.ManegerController;
import com.app.ManegerAndProduct.ProductInfo;
import com.app.ManegerAndProduct.ProductService;
import com.app.customer.CustomerController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Management {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    ProductService productService;

    @Autowired
    private ManegerController manegerController;
    ProductInfo productInfo=new ProductInfo();
    WebDriver webDriver;
    @Given("the user is on the Admin page")
    public void the_user_is_on_the_admin_page() {
        ResponseEntity<String> response = restTemplate.getForEntity("/home", String.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        String htmlContent = response.getBody();
        webDriver = new ChromeDriver();
        webDriver.get("data:text/html;charset=utf-8," + htmlContent);
        sleep(2000);
    }

    @When("the admin click on Add product")
    public void the_admin_click_on_add_product() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        WebElement addLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
        addLink.click();

       sleep(2000);
    }

    @Then("the Add product form should appear")
    public void the_add_product_form_should_appear() {
        assertTrue(webDriver.findElement(By.id("addProductForm")).isDisplayed());
    }

    @Then("the user fills in the product details: Product ID {int} and Product Name {string} Information {string} and price {int} and section{string} and number of it {int} and an image {string}")
    public void theUserFillsInTheProductDetailsProductIDAndProductNameInformationAndPriceAndSectionAndNumberOfItAndAnImage(int productId, String productName, String Information, int price, String section, int numberOfIt, String image) {

   webDriver.findElement(By.id("productId")).sendKeys(Integer.toString(productId));
   webDriver.findElement(By.id("productName")).sendKeys(productName);
   webDriver.findElement(By.id("information")).sendKeys(Information);
   webDriver.findElement(By.id("price")).sendKeys(Integer.toString(price));

   WebElement section1 = webDriver.findElement(By.id("section"));
   Select select1 = new Select(section1);
   select1.selectByVisibleText(section);
   webDriver.findElement(By.id("numberOf")).sendKeys(Integer.toString(numberOfIt));
   webDriver.findElement(By.id("image")).sendKeys(image);
    }
    @Then("the manager submits the form")
    public void the_manager_submits_the_form() {
    webDriver.findElement(By.id("add_pro")).click();
    }

    @Then("the system should display a success message: {string}")
    public void the_system_should_display_a_success_message(String string) {

        manegerController.addProduct(productInfo);

        /*

        عدليييييي انه يطلع الرسالةةةةةةةة

         */

    }

    @Then("the added product details should be visible in the product list")
    public void the_added_product_details_should_be_visible_in_the_product_list() {
        productInfo.setProductId(Integer.parseInt(webDriver.findElement(By.id("productId")).getAttribute("value")));
        productInfo.setProductName(webDriver.findElement(By.id("productName")).getAttribute("value"));
        productInfo.setInformation(webDriver.findElement(By.id("information")).getAttribute("value"));
        productInfo.setPrice(Integer.parseInt(webDriver.findElement(By.id("price")).getAttribute("value")));
        productInfo.setSection(webDriver.findElement(By.id("section")).getAttribute("value"));
        productInfo.setSection(webDriver.findElement(By.id("numberOf")).getAttribute("value"));
        productInfo.setImage(webDriver.findElement(By.id("image")).getAttribute("value"));

        String isAdd=productService.SaveProduct(productInfo);
        assertEquals(isAdd,"Product added successfully");


    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }
    }




}
