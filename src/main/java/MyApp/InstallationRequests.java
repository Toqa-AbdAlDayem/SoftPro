package MyApp;

public class InstallationRequests {
    private String RequestsDate;
    private String RequestsNumber;

    public InstallationRequests(String orderDate, String orderNumber) {
        this.RequestsDate = orderDate;
        this.RequestsNumber = orderNumber;
    }

    public String getOrderDate() {
        return RequestsDate;
    }

    public String getOrderNumber() {
        return RequestsNumber;
    }

}
