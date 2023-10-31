package MyApp;

public class OrderDetail {
    private String orderDate;
    private String orderNumber;

    public OrderDetail(String orderDate, String orderNumber) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
