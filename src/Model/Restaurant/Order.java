package Model.Restaurant;

import Model.Actors.Customer;
import Model.Actors.Deliverer;

public class Order {
    private Customer customer;
    private Restaurant restaurant;
    private Deliverer deliverer;
    private String status;
    private boolean isValidOrder;
    private MenuItem1 item;

    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }
    public Order(Customer customer, Restaurant restaurant, MenuItem1 item) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.item = item;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isValidOrder() {
        return isValidOrder;
    }

    public void setValidOrder(boolean validOrder) {
        isValidOrder = validOrder;
    }
}
