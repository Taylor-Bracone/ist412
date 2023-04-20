package Controller.Restaurant;

import Model.Actors.Customer;
import Model.Restaurant.*;

public class OrderController {
    private RestaurantController restaurantController;
    private Customer customer;
    public OrderController(){
    }

    public OrderController(Customer customer){
        restaurantController = new RestaurantController(customer);
        this.customer = customer;
    }

    public Order createOrder(Restaurant restaurant, Customer customer, MenuItemInterface item){
        Order order = new Order(customer, restaurant, item);
        System.out.println("Order to " + restaurant.getRestaurantName() + " from " + customer.getCustomerID() + " was placed");
        //add this order to the customer and restaurant list
        return order;
    }


    public void acceptOrder(){
        //update order status
        //add to order queue
    }

    public void updateOrderDetails(){
        //change/update details of the order
    }

    public void cancelOrder(){
        //remove order from queue
        //remove order from deliverer
        //mark as cancelled
        //add to historical orders
    }
}
