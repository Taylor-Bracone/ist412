package Controller.Restaurant;

import Model.Restaurant.Order;

public interface OrderNotifier {
    void orderReady(Order order);


}