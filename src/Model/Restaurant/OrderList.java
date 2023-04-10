package Model.Restaurant;


import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static List<Order> orderList;

    public OrderList() {
        this.orderList = new ArrayList<>();
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
