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
    private OrderList orderList;
    private RestaurantOwner restaurantOwner;
    private Restaurant restaurant;

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
        System.out.println("Showing " + restaurant.getRestaurantName() + " menu");
        menuView = new MenuView(restaurant, customer);
        menuView.showMenu(restaurant);
    }

    public void orderItem(Restaurant restaurant, Customer customer, int o){

        Food itemOrdered = restaurant.getFoodOptions().getMenuItemsList().get(o);
        this.addOrderToList(orderController.createOrder(restaurant, customer, itemOrdered));
        ShoppingCartView shoppingCartView = new ShoppingCartView();
        shoppingCartView.addToCart(itemOrdered);
    }


    public void addOrderToList(Order order){
        System.out.println("Order has been added to the restaurant");

        //I suggest adding this to be able to retrieve the added order
        //OrderList.addItem(order);
    }

    public void orderReady(Order order){
        //marks order as ready and initiates chain
        NotificationChain notificationChain = new NotificationChain();
        notificationChain.notifyOrderReady(order);
    }

}
