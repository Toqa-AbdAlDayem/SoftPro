package MyApp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MyApplication {
    public List<OrderDetail> orderDetails;
    public List<InstallationRequests> installationRequests;
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

    public static String convertListToJSONInstall(List<InstallationRequests> installationRequests) {
        // Convert the list of maps to JSON
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < installationRequests.size(); i++) {
            InstallationRequests order = installationRequests.get(i);
            json.append("{");
            json.append("\"Order Date\":\"").append(order.getOrderDate()).append("\",");
            json.append("\"Order Number\":\"").append(order.getOrderNumber()).append("\"");
            json.append("}");
            if (i < installationRequests.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    public void runJSInstall(WebDriver driver, List<InstallationRequests> installationRequests) {
        System.out.println("Data to be passed to JavaScript: " +  convertListToJSONInstall(installationRequests));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Execute the JavaScript function and pass the JSON data
        jsExecutor.executeScript("initializeInstallationRequests(arguments[0]);", convertListToJSONInstall(installationRequests));
    }

}
