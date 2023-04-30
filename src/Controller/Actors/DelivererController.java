package Controller.Actors;

import Model.Actors.Deliverer;
import Model.Restaurant.Order;
import Model.Restaurant.HistoricalOrderList;
import View.Actors.DelivererOptionsView;
import View.Actors.DeliveryOrderView;

import java.util.ArrayList;

public class DelivererController {
    private DeliveryOrderView deliveryOrderView;
    private Deliverer deliverer;
    private DelivererOptionsView delivererOptionsView;
    public DelivererController (){

    }
    public DelivererController (Deliverer deliverer){
        this.deliverer = deliverer;
        //this.deliveryOrderView = new DeliveryOrderView(deliverer);
        this.delivererOptionsView = new DelivererOptionsView(deliverer);
    }

    public void displayAssignedOrder(Deliverer deliverer, ArrayList<Order> orderArrayList){
        for (Order order : orderArrayList) {
            if (order.getDeliverer().getDelivererID().equals(deliverer.getDelivererID())) {
                System.out.println("Details of Your Assigned Delivery: ");
                System.out.println("Customer Name: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
                System.out.println("Customer Address: " + order.getCustomer().getAddress());
                System.out.println("Customer Phone Number: " + order.getCustomer().getPhoneNumber());
            }
        }
    }

    public void displayPastOrders(Deliverer deliverer){
        for (Order order : HistoricalOrderList.getHistoricalOrderList()) {
            if (order.getDeliverer().getDelivererID().equals(deliverer.getDelivererID())) {
                System.out.println("Details of Past Orders: ");
                System.out.println("Customer Name: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
                System.out.println("Customer Address: " + order.getCustomer().getAddress());
                System.out.println("Customer Phone Number: " + order.getCustomer().getPhoneNumber());
            }
        }
    }

    public void displayAssignedOrder(ArrayList<Order> orderArrayList) {
    }
}
