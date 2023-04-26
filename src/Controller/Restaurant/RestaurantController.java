package Controller.Restaurant;

import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Actors.RestaurantOwner;
import Model.Actors.User;
import Model.Restaurant.*;
import View.Restaurant.MenuView;
import View.Restaurant.RestaurantOrderView;
import View.ShoppingCartView;

import java.util.List;

public class RestaurantController {
    private MenuView menuView;
    private OrderController orderController;
    private Customer customer;
    private RestaurantOwner restaurantOwner;

    public RestaurantController(){
        //this.menuView = new MenuView();
        this.orderController = new OrderController();
    }

    public RestaurantController(Customer customer){
        //this.menuView = new MenuView();
        this.orderController = new OrderController();
        this.customer = customer;
    }
    public RestaurantController(RestaurantOwner restaurantOwner){
        //this.menuView = new MenuView();
        this.orderController = new OrderController();
        this.restaurantOwner = restaurantOwner;
    }

    public Restaurant createRestaurant(String name, String location, RestaurantOwner owner){
        //creates a new restaurant object
        return null;
    }

    public void updateRestaurant(){
        //updates the restaurant details
    }

    public void orderFromMenu(Restaurant restaurant, Customer customer){
        menuView = new MenuView(restaurant, customer);
        menuView.showMenu(restaurant);
    }

    public void orderItem(Restaurant restaurant, Customer customer, int o){

        Food itemOrdered = restaurant.getFoodOptions().getMenuItemsList().get(o);
        ShoppingCartView shoppingCartView = new ShoppingCartView(customer, restaurant, itemOrdered);
        shoppingCartView.addToCart(itemOrdered);
    }


    public void orderReady(Order order){
        //marks order as ready and initiates chain
        NotificationChain notificationChain = new NotificationChain();
        notificationChain.notifyOrderReady(order);
    }

}
