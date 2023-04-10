package Controller.Restaurant;

import Model.Restaurant.Order;

public class CustomerNotifier implements OrderNotifier{
    @Override
    public void orderReady(Order order) {
        System.out.println("Send email to customer");
    }
}