package Model.Restaurant;

import Model.Actors.Customer;
import Model.Actors.Deliverer;

import java.util.ArrayList;

public class Order {
    private Customer customer;
    private Restaurant restaurant;
    private Deliverer deliverer;
    private Order order;
    private String status;
    private boolean isValidOrder;
    private ArrayList<MenuItem> items;

    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }
    public Order(Customer customer, Restaurant restaurant, ArrayList<MenuItem> items) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
    }

    public Order(Customer customer, Restaurant restaurant, Deliverer deliverer) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.deliverer = deliverer;
    }

    public Order(Customer customer, Restaurant restaurant, Deliverer deliverer, ArrayList<MenuItem> items) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.deliverer = deliverer;
        this.items = items;
    }


    public Order(Customer customer, Order order, Deliverer deliverer) {
        this.customer = customer;
        this.order = order;
        this.deliverer = deliverer;
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

    public String listItems(){
        String list = "";
        for (MenuItem item: this.items) {
            list = list + item + "\n";
        }
        return list;
    }

    @Override
    public String toString() {
        String list = listItems();
        return "Order{" +
                "customer=" + customer +
                ", restaurant=" + restaurant +
                ", items=" + list + '}';
    }

//    @Override
//    public String toString() {
//        String list = listItems();
//        return "Order{\n" +
//                "customer= " + customer.getFirstName() +
//                ", \nrestaurant= " + restaurant.getRestaurantName() +
//                ", \ndeliverer= " + deliverer.getDelivererID() +
//                ", \nstatus= '" + status + '\'' +
//                ", \nisValidOrder= " + isValidOrder +
//                ", \nitems= \n" + list +
//                '}';
//    }
}
