package Model.Restaurant;


import org.junit.runner.manipulation.Ordering;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static List<Order> orderList;
    private String customerName;
    private String restaurantName;
    private int orderID;
    private String status;

    public OrderList(String customerName, String restaurantName, int orderID, String status) {
        this.orderList = new ArrayList<>();
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.orderID = orderID;
        this.status = status;
    }

    public OrderList() {

    }

    // retrieve orderList
    public static List<Order> getOrderList(){
        return orderList;
    }

    // add item
    public static void addItem(Order order) {
        orderList.add(order);
    }

    // remove item
    public static void removeItem(Order order) {
        orderList.remove(order);
    }
}
