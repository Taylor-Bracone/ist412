package Model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class PastOrderList {
    private static List<Order> pastOrderList;

    public PastOrderList() {
        this.pastOrderList = new ArrayList<>();
    }

    // retrieve orderList
    public static List<Order> getPastOrderList(){
        return pastOrderList;
    }

    // add item
    public static void addItem(Order order) {
        pastOrderList.add(order);
    }

    // remove item
    public static void removeItem(Order order) {
        pastOrderList.remove(order);
    }
}
