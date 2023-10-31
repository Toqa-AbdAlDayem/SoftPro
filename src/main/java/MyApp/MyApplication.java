package MyApp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class MyApplication {
    public List<OrderDetail> orderDetails;
    public static String convertListToJSON(List<OrderDetail> orderDetails) {
        // Convert the list of maps to JSON
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < orderDetails.size(); i++) {
            OrderDetail order = orderDetails.get(i);
            json.append("{");
            json.append("\"Order Date\":\"").append(order.getOrderDate()).append("\",");
            json.append("\"Order Number\":\"").append(order.getOrderNumber()).append("\"");
            json.append("}");
            if (i < orderDetails.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    public void runJS(WebDriver driver, List<OrderDetail> orderDetails) {
        System.out.println("Data to be passed to JavaScript: " +  convertListToJSON(orderDetails));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Execute the JavaScript function and pass the JSON data
        jsExecutor.executeScript("initializeOrderDetails(arguments[0]);", convertListToJSON(orderDetails));
    }

}
