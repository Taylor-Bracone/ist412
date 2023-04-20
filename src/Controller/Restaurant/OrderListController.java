package Controller.Restaurant;

import Model.Restaurant.OrderList;
import View.OrderListView;

public class OrderListController {
    private OrderListView orderListView;

    public void addOrderToQueue(Order order){
        //add order to a queue of current orders
    }

    public void removeOrderFromQueue(Order order){
        // searches the queue for the specified order
        // removes order from the queue
    }

    public void clearQueue(){
        // empties the order list
    }

    public void viewOrderList(){
        // shows view of the current orders
        this.orderListView = new OrderListView();
        // Display pending orders in the view
        orderListView.listPendingOrders(OrderList.getOrderList());
    }
}
