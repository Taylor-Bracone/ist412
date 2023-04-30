package Controller.Restaurant;

import Model.Restaurant.Order;

public class CustomerNotifier implements OrderNotifier{
    @Override
    public void orderReady(Order order) {
        System.out.println("Send email to customer");
    }

    @Override
    public void orderPlaced(Order order) {
        System.out.println("Order was placed: " + order.toString());
    }
}