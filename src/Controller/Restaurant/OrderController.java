package Controller.Restaurant;

import Model.Actors.Customer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderController {
    private RestaurantController restaurantController;
    private Customer customer;

    public OrderController() {
    }

    public OrderController(Customer customer) {
        restaurantController = new RestaurantController(customer);
        this.customer = customer;
    }

    public Order createOrder(Restaurant restaurant, Customer customer, MenuItemInterface item) {
        Order order = new Order(customer, restaurant, item);
        return order;
    }




}

