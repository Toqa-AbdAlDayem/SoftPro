package StepDefinitions;

import com.app.ManegerAndProduct.*;

import com.app.customer.CustomerDb;
import com.app.customer.DataForm;
import com.app.customer.DataService;
import io.cucumber.java.en.And;
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


public class Management {
    ProductDb productDb=new ProductDb();
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    ProductService productService;
    String result;
    @Autowired
    private ManegerController manegerController;
    ProductInfo productInfo=new ProductInfo();
    @Autowired
    WebDriver webDriver;
    @Autowired
    DataService dataService;

    CatagroiesForm catagroiesForm=new CatagroiesForm();

    private DataForm dataForm=new DataForm();
    private LogInSteps logInSteps=new LogInSteps();
    private CustomerDb customerDb=new CustomerDb();
    @Given("the user is on the Admin page")
    public void the_user_is_on_the_admin_page() {
    /*    logInSteps.i_am_on_the_login_page();
        logInSteps.i_enter_my_admin_username_and_password("eman","555");
        logInSteps.i_click_the_button("LogInBtn");
*/


        webDriver.get("http://localhost:"+CucumberIT.getPort()+"/home");
        sleep(2000);
    }

    @When("the admin clicks on Management")
    public void theAdminClicksOnManagement() {
     webDriver.findElement(By.id("management")).click();

    }
    @Then("a form should appear")
    public void aFormShouldAppear() {
      Boolean Form=  webDriver.findElement(By.id("addProductForm")).isDisplayed();
      Assertions.assertTrue(Form);

    }

    @Then("the {string} section should appear with delete button")
    public void theSectionShouldAppearWithDeleteButton(String AddCatagries) {
       boolean delete = webDriver.findElement(By.id("deleteButton")).isDisplayed();
       boolean Add= webDriver.findElement(By.id("addNewButton")).isDisplayed();
       boolean result=(delete & Add);
       Assertions.assertTrue(result);
    }

    @When("the admin clicks on Add Category")
    public void theAdminClicksOnAddCategory() {
        webDriver.findElement(By.id("addNewButton")).click();
    }
    @And("the admin fills in the category details: Category Name {string}")
    public void theAdminFillsInTheCategoryDetailsCategoryName(String catagryName) {

        webDriver.findElement(By.id("categorytId")).sendKeys("1285");
        webDriver.findElement(By.id("categoryName")).sendKeys(catagryName);
        catagroiesForm.setCataName(catagryName);
    }

    @And("the manager submits the Add Categories form")
    public void theManagerSubmitsTheAddCategoriesForm() {

        webDriver.findElement(By.id("add categories")).click();

    }
    @Then("the system should display a success save categories message: {string}")
    public void theSystemShouldDisplayASuccessSaveCategoriesMessage(String massege) {
      String actual=  productService.SaveCatagroies(catagroiesForm);
        assertEquals(massege,actual);

    }
    @Then("the system should display an error message: {string}")
    public void theSystemShouldDisplayAnErrorMessage(String massege) {
        String actual=  productService.SaveCatagroies(catagroiesForm);
        assertEquals(massege,actual);
    }
    @Then("the Add product form should appear")
    public void the_add_product_form_should_appear() {
        //assertTrue(webDriver.findElement(By.id("addProductForm")).isDisplayed());
    }

    @When("the admin clicks on {string} category")
    public void theAdminClicksOnCategory(String ExteriorAccesoris) {
        webDriver.findElement(By.id("Exterior Accessories")).click();

    }

    @Then("the admin should be in a {string} product page")
    public void theAdminShouldBeInAProductPage(String page) {
    //assertEquals(webDriver.getTitle(),page);
    }

    @Then("the {string} section should appear with delete and update buttons")
    public void theSectionShouldAppearWithDeleteAndUpdateButtons(String arg0) {
        boolean delete = webDriver.findElement(By.id("deleteButton")).isDisplayed();
        boolean update = webDriver.findElement(By.id("updateButton")).isDisplayed();
        boolean Add= webDriver.findElement(By.id("addNewButton")).isDisplayed();
        boolean result=(delete & Add & update);
        Assertions.assertTrue(result);
    }

    @When("the admin clicks on Add Product")
    public void theAdminClicksOnAddProduct() {
        webDriver.findElement(By.id("addNewButton")).click();
    }
    @Then("the manager submits the form")
    public void the_manager_submits_the_form() {

    webDriver.findElement(By.id("add_pro")).click();
    sleep(2000);
    }

    @Then("the system should display a success message: {string}")
    public void the_system_should_display_a_success_message(String string) {


        result=productService.SaveProduct(productInfo,productDb);
        assertEquals(result,"Product added successfully");

sleep(2000);

    }
    @And("the admin fills in the product details: Product ID {string}, Product Name {string}, Information {string}, Price {string}, Section {string}, Number {string}, Image {string}")
    public void theAdminFillsInTheProductDetailsProductIDProductNameInformationPriceSectionNumberImage(String productId, String productName, String info,String price, String section, String number, String arg6) {

        webDriver.findElement(By.id("productId")).sendKeys(productId);
        webDriver.findElement(By.id("productName")).sendKeys(productName);
        webDriver.findElement(By.id("information")).sendKeys(info);
        webDriver.findElement(By.id("price")).sendKeys(price);

        WebElement serviceSelect = webDriver.findElement(By.id("section"));
        Select select2 = new Select(serviceSelect);
        select2.selectByVisibleText(section);
        webDriver.findElement(By.id("numberOf")).sendKeys(number);

        productInfo.setProductId(Integer.parseInt(webDriver.findElement(By.id("productId")).getAttribute("value")));
        productInfo.setProductName(webDriver.findElement(By.id("productName")).getAttribute("value"));
        productInfo.setInformation(webDriver.findElement(By.id("information")).getAttribute("value"));
        productInfo.setPrice(Integer.parseInt(webDriver.findElement(By.id("price")).getAttribute("value")));
        productInfo.setSection(webDriver.findElement(By.id("section")).getAttribute("value"));
        productInfo.setSection(webDriver.findElement(By.id("numberOf")).getAttribute("value"));
        productInfo.setImage(webDriver.findElement(By.id("image")).getAttribute("value"));
        sleep(2000);

    }
    @Then("the added product details should be visible in the product list")
    public void the_added_product_details_should_be_visible_in_the_product_list() {
        /*productInfo.setProductId(Integer.parseInt(webDriver.findElement(By.id("productId")).getAttribute("value")));
        productInfo.setProductName(webDriver.findElement(By.id("productName")).getAttribute("value"));
        productInfo.setInformation(webDriver.findElement(By.id("information")).getAttribute("value"));
        productInfo.setPrice(Integer.parseInt(webDriver.findElement(By.id("price")).getAttribute("value")));
        productInfo.setSection(webDriver.findElement(By.id("section")).getAttribute("value"));
        productInfo.setSection(webDriver.findElement(By.id("numberOf")).getAttribute("value"));
        productInfo.setImage(webDriver.findElement(By.id("image")).getAttribute("value"));

        String isAdd=productService.SaveProduct(productInfo);
        assertEquals(isAdd,"Product added successfully");*/


    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }
    }


    @And("the admin fills in the product details with new product : Product ID {string}, Product Name {string}, Information {string}, Price {string}, Section {string}, Number {string}, Image {string}")
    public void theAdminFillsInTheProductDetailsWithNewProductProductIDProductNameInformationPriceSectionNumberImage(String productId, String productName, String info,String price, String section, String number, String arg6) {
        webDriver.findElement(By.id("productId")).sendKeys(productId);
        webDriver.findElement(By.id("productName")).sendKeys(productName);
        webDriver.findElement(By.id("information")).sendKeys(info);
        webDriver.findElement(By.id("price")).sendKeys(price);

        WebElement serviceSelect = webDriver.findElement(By.id("section"));
        Select select2 = new Select(serviceSelect);
        select2.selectByVisibleText(section);
        webDriver.findElement(By.id("numberOf")).sendKeys(number);

        productInfo.setProductId(Integer.parseInt(webDriver.findElement(By.id("productId")).getAttribute("value")));
        productInfo.setProductName(webDriver.findElement(By.id("productName")).getAttribute("value"));
        productInfo.setInformation(webDriver.findElement(By.id("information")).getAttribute("value"));
        productInfo.setPrice(Integer.parseInt(webDriver.findElement(By.id("price")).getAttribute("value")));
        productInfo.setSection(webDriver.findElement(By.id("section")).getAttribute("value"));
        productInfo.setSection(webDriver.findElement(By.id("numberOf")).getAttribute("value"));
        productInfo.setImage(webDriver.findElement(By.id("image")).getAttribute("value"));
        sleep(2000);
    }

    @When("the admin clicks on Update Product")
    public void theAdminClicksOnUpdateProduct() {
        webDriver.findElement(By.id("updateButton")).click();

    }
}
