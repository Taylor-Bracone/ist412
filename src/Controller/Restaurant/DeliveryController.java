package Controller.Restaurant;

import Model.Actors.Deliverer;
import Model.Actors.DelivererList;
import Model.Restaurant.Order;
import Model.Restaurant.PastOrderList;
import Model.Restaurant.Restaurant;
import View.Actors.DeliveryOrderView;

public class DeliveryController {
    private DelivererList delivererList;
    private DeliveryOrderView deliveryOrderView;

    public DeliveryController() {

    }
    public void assignDelivererToOrder(Deliverer deliverer, Order order){
        //gives/sets order to deliverer for delivery
        order.setDeliverer(deliverer);
        deliverer.setAvailabilityStatus(false);
    }

    public void requestDeliverOrderList(){
        //shows user a list of pending orders that have not been assigned to a deliverer yet
        //deliveryOrderView.listPendingOrders(orderList.getOrderList());
    }

    public void requestDelivererQueue(Restaurant restaurant){
        //shows restaurant a list of available deliverers in the queue that can deliver an order
        //deliveryOrderView.listAvailableDeliverers(delivererList.getDelivererList());
    }

    public void completeDelivery(Order order, Deliverer deliverer){
        //marks delivery as finished when completed
        //adds delivery to a past orders list
        //adds delivery to the deliverers list of historical deliveries ?
        order.setStatus("Completed");
        PastOrderList.addItem(order);
    }
}
