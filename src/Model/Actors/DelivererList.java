package Model.Actors;

import Model.Restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class DelivererList {
    private static List<Deliverer> delivererList;

    public DelivererList() {
        this.delivererList = new ArrayList<>();
    }

    // retrieve orderList
    public static List<Deliverer> getDelivererList(){
        return delivererList;
    }

    // add item
    public static void addItem(Deliverer deliverer) {
        delivererList.add(deliverer);
    }

    // remove item
    public static void removeItem(Deliverer deliverer) {
        delivererList.remove(deliverer);
    }
}
