package Controller.Actors;

import Controller.Restaurant.MenuItemController;
import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.RestaurantOperator;
import Model.Actors.RestaurantOwner;
import Model.Actors.User;
import Model.Restaurant.Menu;
import Model.Restaurant.MenuItem;
import Model.Restaurant.MenuItem1;
import Model.Restaurant.Restaurant;
import View.Restaurant.RestaurantOrderView;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantOwnerController {
    /**
     * handles logic for restaurant owner controller
     * @param restaurant
     * @return
     */
    public RestaurantOrderView restaurantOrderView;
    private RestaurantListController restaurantListController;
    private RestaurantController restaurantController;
    private MenuItemController menuItemController;
    private ArrayList<Restaurant> restaurants;
    private RestaurantOwner restaurantOwner;
    private ArrayList<Restaurant> pendingRestaurantAcceptList = new ArrayList<>();
    private ArrayList<RestaurantOperator> restaurantOperators = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public RestaurantOwnerController(){
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController();
        this.restaurants = restaurantListController.viewRestaurantList();
    }

    public RestaurantOwnerController(User restaurantOwner){
        this.restaurantOrderView = new RestaurantOrderView(restaurantOwner);
    }

    public RestaurantOwnerController(RestaurantOwner restaurantOwner){
        this.restaurantOrderView = new RestaurantOrderView(restaurantOwner);
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController(restaurantOwner);
        this.restaurants = restaurantListController.viewRestaurantList();
        this.restaurantOwner = restaurantOwner;
    }

    public void requestToBeAdded(Restaurant restaurant){
        // writes a 'request' to be added to the pending restaurant list
        this.pendingRestaurantAcceptList.add(restaurant);
    }

    public void requestToBeRemoved(Restaurant restaurant){
        // write to be 'invalidated' from the system
        restaurantListController.viewRestaurantList().remove(restaurant);
    }

    public void addOperator(RestaurantOperator restaurantOperator){
        // be able to add 'operators' to their restaurant
        restaurantOperators.add(restaurantOperator);
        System.out.println("Restaurant operator was successfully added.");
    }
    public void addMenuItem(Restaurant restaurant, Menu menu){
        //adds menu item
        System.out.println("What is the name of the menu item?");
        String menuItemName = scanner.nextLine();
        System.out.println("What is the description of the menu item?");
        String menuItemDescription = scanner.nextLine();
        System.out.println("What is the price?");
        Double price = scanner.nextDouble();
        System.out.println("Menu item is being added...");
        menuItemController.createMenuItem(restaurant, menuItemName, menuItemDescription, price);
    }

    /*
    public void updateMenu(Restaurant restaurant, Menu menu){
        //updates menu
    }

     */

    public void updateMenuItem(Restaurant restaurant, Menu menu, MenuItem1 menuItem){
        //updates menu item
        System.out.println("What is the name of the menu item?");
        String menuItemName = scanner.nextLine();
        System.out.println("What is the description of the menu item?");
        String menuItemDescription = scanner.nextLine();
        System.out.println("What is the price?");
        Double price = scanner.nextDouble();
        System.out.println("Menu item is being updated...");
        menuItemController.updateMenuItem(menuItem, menuItemName, menuItemDescription, price);
    }

    public void removeMenuItem(Restaurant restaurant, Menu menu, MenuItem1 menuItem){
        //removes menu item
        menuItemController.removeMenuItem(restaurant, menuItem);
        System.out.println("Menu item is being removed...");
    }
}
