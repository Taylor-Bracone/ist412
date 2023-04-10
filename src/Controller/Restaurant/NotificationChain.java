package Controller.Restaurant;

import Model.Restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class NotificationChain {
    private final List orderNotifiers = new ArrayList<>();

    public NotificationChain(){
        orderNotifiers.add(new CustomerNotifier());
        orderNotifiers.add(new DelivererNotifier());
    }

    public void notifyOrderReady(Order order){
        for (Object orderNotifier : orderNotifiers) {
            OrderNotifier notifier = (OrderNotifier) orderNotifier;
            notifier.orderReady(order);
        }
    }
}