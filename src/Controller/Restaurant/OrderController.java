package Controller.Restaurant;

import Model.Actors.Customer;
import Model.Restaurant.*;

import java.util.ArrayList;

public class OrderController {
    private RestaurantController restaurantController;
    private Customer customer;

    public OrderController() {
    }

    public OrderController(Customer customer) {
        restaurantController = new RestaurantController(customer);
        this.customer = customer;
    }

    public Order createOrder(Restaurant restaurant, Customer customer, ArrayList<MenuItem> item) {
        Order order = new Order(customer, restaurant, item);
        return order;
    }




}

