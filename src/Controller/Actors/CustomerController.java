package Controller.Actors;

import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.Customer;
import Model.Restaurant.Restaurant;
import View.Actors.CustomerOrderHistory;
import View.Actors.CustomerOrderView;
import java.io.IOException;
import java.util.ArrayList;


public class CustomerController {
    public CustomerOrderView orderView;
    private RestaurantListController restaurantListController;
    private RestaurantController restaurantController;
    private ArrayList<Restaurant> restaurants;
    private Customer customer = new Customer();

    public CustomerController() throws IOException {
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController();
        this.restaurants = restaurantListController.viewRestaurantList();
    }
    public CustomerController(Customer customer) throws IOException {
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController(customer);
        this.restaurants = restaurantListController.viewRestaurantList();
        this.orderView = new CustomerOrderView(customer);
        this.customer = customer;
    }

    public void updateCustomerAccount(String firstName, String lastName, String address, String name) throws IOException {
        customer.writeToCustomerFile(firstName, lastName, address, name);
    }


    public void customerOrderHistory(Customer customer) throws IOException {
        CustomerOrderHistory customerOrderHistory = new CustomerOrderHistory(customer);
    }

    public void showRestaurantOrders(Customer customer){
        //shows list of orders sent to the Restaurant
        System.out.println("List of " + customer.getCustomerID() +" current orders");
    }

}
