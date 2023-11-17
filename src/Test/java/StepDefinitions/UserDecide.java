package StepDefinitions;

import com.app.AppointmentDb;
import com.app.AppointmentForm;
import com.app.AppointmentService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class UserDecide {
    @Autowired
    AppointmentService appointmentService;
 WebDriver webDriver=null;
    @Given("the user is on the chosen page")
    public void the_user_is_on_the_chosen_page() {
       webDriver=new ChromeDriver();
       webDriver.get("file://C://Users//PC//Desktop//SoftPro//src//main//resources//templates//chose.html");
       sleep(500);
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        webDriver.findElement(By.id("Appointment")).click();
        sleep(500);
    }

    @Then("a dialog box should appear")
    public void a_dialog_box_should_appear() {


        By dialogBoxLocator = By.id("appointmentForm");
        WebElement dialogBox = webDriver.findElement(dialogBoxLocator);
        assertTrue("Dialog box should be visible", dialogBox.isDisplayed());
        sleep(2000);
    }

    @And("the user selects {string} and {string} and {string}")
    public void theUserSelectsAndAnd(String day, String hour, String service) {

        WebElement daySelect = webDriver.findElement(By.id("Day"));
        Select select = new Select(daySelect);
        select.selectByVisibleText(day);

        WebElement hourSelect = webDriver.findElement(By.id("hours"));
        Select select1 = new Select(hourSelect);
        select1.selectByVisibleText(hour);

        WebElement serviceSelect = webDriver.findElement(By.id("Service"));
        Select select2 = new Select(serviceSelect);
        select2.selectByVisibleText(service);


    }
    @Then("the user submits the appointment request")
    public void the_user_submits_the_appointment_request() {
        AppointmentForm appointmentForm =new AppointmentForm();
        appointmentForm.setDay(webDriver.findElement(By.id("Day")).getAttribute("value"));
        appointmentForm.setHour( webDriver.findElement(By.id("hours")).getAttribute("value"));

        appointmentForm.setService(String.valueOf(webDriver.findElement(By.id("Service"))));
        AppointmentDb appointmentDb =new AppointmentDb();
     boolean isSend =appointmentService.creatRequast(appointmentForm,appointmentDb);
     assertTrue(isSend);

    }

    @Then("the request should be saved successfully")
    public void the_request_should_be_saved_successfully() {

    }

    @When("the user clicks on the {string} button1")
    public void the_user_clicks_on_the_button1(String Buy) {
        webDriver.findElement(By.id("by")).click();
    }

    @Then("the user should be on the home page")
    public void the_user_should_be_on_the_home_page() {

    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println("Erooooooooooooooooooooor");
        }
    }


}
