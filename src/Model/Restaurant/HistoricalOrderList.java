package Model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class HistoricalOrderList {
    private static List<Order> historicalOrderList;

    public HistoricalOrderList() {
        this.historicalOrderList = new ArrayList<>();
    }

    // retrieve orderList
    public static List<Order> getHistoricalOrderList(){
        return historicalOrderList;
    }

    // add item
    public static void addItem(Order order) {
        historicalOrderList.add(order);
    }

    // remove item
    public static void removeItem(Order order) {
        historicalOrderList.remove(order);
    }
}
