package Controller.Actors;

import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.Customer;
import Model.Actors.User;
import Model.Restaurant.Food;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import Model.Restaurant.Restaurant;
import View.Actors.CustomerOrderView;
import View.ShoppingCartView;

import java.util.ArrayList;


public class CustomerController {
    public CustomerOrderView orderView;
    private RestaurantListController restaurantListController;
    private RestaurantController restaurantController;
    private ArrayList<Restaurant> restaurants;
    private Customer customer;
    /**
     * handles all logic for customer, has methods for everything the customer can do
     */
    /*public CustomerController(Customer customer){
        this.orderView = new CustomerOrderView(customer);
        this.restaurantListController = new RestaurantListController();
        this.restaurants = restaurantListController.viewRestaurantList();
    }*/
    public CustomerController(){
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController();
        this.restaurants = restaurantListController.viewRestaurantList();
    }
    public CustomerController(Customer customer){
        this.orderView = new CustomerOrderView(customer);
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController(customer);
        this.restaurants = restaurantListController.viewRestaurantList();
        this.customer = customer;
    }
    public void placeOrder(String restaurant, Customer customer){
        System.out.println("Ordering from " + restaurant);
        for (Restaurant r : restaurants){
            if (r.getRestaurantName().equals(restaurant)){
                restaurantController.orderFromMenu(r, customer);
            }
        }
    }


    public void viewRestaurantList(){
        System.out.println("This is a list of restaurants");
        for (Restaurant r : restaurants){
            System.out.println(r.getRestaurantName());
        }
    }

    public void updateCustomerAccount(String firstName, String lastName, String address){
        //customer can update their account information
        System.out.println("Your information was updated");
        System.out.println(firstName + " " + lastName + " " + address);
    }


    public void customerOrderHistory(Customer customer){
        //reads from file to show all past orders for one customer
        System.out.println("This is "+ customer.getCustomerID()+ " order history");
    }

    public void showRestaurantOrders(Customer customer){
        //shows list of orders sent to the Restaurant
        System.out.println("List of " + customer.getCustomerID() +" current orders");
    }

}
