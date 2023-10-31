package StepDefinitions;

import MyApp.MyApplication;
import MyApp.OrderDetail;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditProfileSteps {
    MyApplication app;
    public EditProfileSteps(){
        app=new MyApplication();
    }
    private List<Map<String, String>> orderDetailsData;

    private WebDriver driver = null;

    @Given("I am a logged-in customer")
    public void i_am_a_logged_in_customer() {
        driver =new ChromeDriver();
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Customer.html");
    }

    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String string) {
       driver.findElement(By.id(string)).click();
    }

    @When("I update my profile information with the following details:")
    public void i_update_my_profile_information_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //Name             | John Doe                    |
        //      | Email            | john.doe@example.com        |
        //      | Phone Number     | +1 555-555-5555             |
        //      | Shipping Address | 123 Main Street, City, USA  |
        //      | Vehicle Info
        // For other transformations you can register a DataTableType.


        Map<String,String> map=dataTable.asMap(String.class,String.class);
        String name =map.get("Name");
        String email =map.get("Email");
        String phone =map.get("Phone Number");
        String address =map.get("Shipping Address");
        String carInfo =map.get("Vehicle Info");


        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("ShippingAddress")).clear();
        driver.findElement(By.id("ShippingAddress")).sendKeys(address);
        driver.findElement(By.id("VehicleInfo")).clear();
        driver.findElement(By.id("VehicleInfo")).sendKeys(carInfo);

    }

    @When("I confirm the changes")
    public void i_confirm_the_changes() {
        driver.findElement(By.id("editButton")).click();
    }

    @Then("my profile information should be updated successfully")
    public void my_profile_information_should_be_updated_successfully() {
        System.out.println("Doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    @When("I cancel the changes")
    public void i_cancel_the_changes() {
        driver.findElement(By.id("cancelButton")).click();
    }

    @Then("my profile information should not be updated")
    public void my_profile_information_should_not_be_updated() {
        System.out.println("Doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    @When("I click on {string} button")
    public void i_click_on_button(String button) {
        driver.findElement(By.id(button)).click();
    }


    @When("I go to the {string} section")
    public void i_go_to_the_section(String string) {
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Orders.html");
    }

    @Then("I should see a list of my previous orders with the following details for each order:")
    public void i_should_see_a_list_of_my_previous_orders_with_the_following_details_for_each_order(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Orders.html");
        if (app.orderDetails == null) {
            app.orderDetails = new ArrayList<>();
        }
        List<Map<String, String>> orderDetailsData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> order : orderDetailsData) {
            String orderDate = order.get("Order Date");
            String orderNumber = order.get("Order Number");
            app.orderDetails.add(new OrderDetail(orderDate, orderNumber));
        }
        app.runJS(driver,app.orderDetails);


        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
            // Use the order details for validation or ot32her actions
    }



    @Then("I can click on an order to view more details if needed")
    public void i_can_click_on_an_order_to_view_more_details_if_needed() {
//        for (Map<String, String> order : orderDetailsData) {
//            String orderDate = order.get("Order Date");
//            String orderNumber = order.get("Order Number");
//            String itemsPurchased = order.get("Items Purchased");
//            String orderStatus = order.get("Order Status");
//            String totalCost = order.get("Total Cost");
//            String trackingInfo = order.get("Tracking Info");
            System.out.println("Doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

            // Use the order details for validation or other actions
 //       }
    }

    @When("I access the {string} section")
    public void i_access_the_section(String string) {
        driver.get("file://C://xampp//htdocs//web//selcuc//src//main//resources//Installation.html");
    }

    @Then("I should see a list of my installation requests with the following details for each request:")
    public void i_should_see_a_list_of_my_installation_requests_with_the_following_details_for_each_request(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("I can reschedule or cancel an appointment if necessary")
    public void i_can_reschedule_or_cancel_an_appointment_if_necessary() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
