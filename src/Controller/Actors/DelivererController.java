package Controller.Actors;

import Model.Actors.Deliverer;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import Model.Restaurant.PastOrderList;
import View.Actors.DeliveryOrderView;

public class DelivererController {
    private DeliveryOrderView deliveryOrderView;
    private Deliverer deliverer;

    public DelivererController (){

    }
    public DelivererController (Deliverer deliverer){
        this.deliverer = deliverer;
        this.deliveryOrderView = new DeliveryOrderView(deliverer);
    }

    public void displayAssignedOrder(Deliverer deliverer){
        for (Order order : OrderList.getOrderList()) {
            if (order.getDeliverer().getDelivererID().equals(deliverer.getDelivererID())) {
                System.out.println("Details of Your Assigned Delivery: ");
                System.out.println("Customer Name: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
                System.out.println("Customer Address: " + order.getCustomer().getAddress());
                System.out.println("Customer Phone Number: " + order.getCustomer().getPhoneNumber());
            }
        }
    }

    public void displayPastOrders(Deliverer deliverer){
        for (Order order : PastOrderList.getPastOrderList()) {
            if (order.getDeliverer().getDelivererID().equals(deliverer.getDelivererID())) {
                System.out.println("Details of Past Orders: ");
                System.out.println("Customer Name: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
                System.out.println("Customer Address: " + order.getCustomer().getAddress());
                System.out.println("Customer Phone Number: " + order.getCustomer().getPhoneNumber());
            }
        }
    }
}
