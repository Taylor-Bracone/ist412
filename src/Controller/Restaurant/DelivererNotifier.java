package Controller.Restaurant;

import Model.Restaurant.Order;

public class DelivererNotifier implements OrderNotifier{
    @Override
    public void orderReady(Order order) {
        System.out.println("Notifies driver");
    }

    @Override
    public void orderPlaced(Order order) {

    }
}