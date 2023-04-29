package Controller.Actors;

import Controller.Restaurant.MenuItemController;
import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.RestaurantOperator;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Food;
import Model.Restaurant.Menu;
import Model.Restaurant.MenuItemInterface;
import Model.Restaurant.Restaurant;
import View.Restaurant.MenuView;
import View.Restaurant.RestaurantOrderView;
import View.Actors.ResOwnerOptionsView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantOwnerController {
    public RestaurantOrderView restaurantOrderView;
    private RestaurantListController restaurantListController;
    private RestaurantController restaurantController;
    private MenuItemController menuItemController;
    private ArrayList<Restaurant> restaurants;
    private RestaurantOwner restaurantOwner;
    private ArrayList<Restaurant> pendingRestaurantAcceptList = new ArrayList<>();
    private ArrayList<RestaurantOperator> restaurantOperators = new ArrayList<>();
    private MenuView menuView;
    private ResOwnerOptionsView resOwnerOptionsView;
    Scanner scanner = new Scanner(System.in);

    public RestaurantOwnerController() throws IOException {
        this.restaurantListController = new RestaurantListController();
        this.restaurantController = new RestaurantController();
        this.restaurants = restaurantListController.viewRestaurantList();
    }

    public RestaurantOwnerController(RestaurantOwner restaurantOwner) throws IOException {
        this.resOwnerOptionsView = new ResOwnerOptionsView(restaurantOwner);
    }

    public void requestToBeAdded(Restaurant restaurant){
        // writes a 'request' to be added to the pending restaurant list
        this.pendingRestaurantAcceptList.add(restaurant);
    }

    public void requestToBeRemoved(Restaurant restaurant) throws IOException {
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
        Double menuItemPrice = scanner.nextDouble();
        System.out.println("Menu item is being added...");
        Food foodItem = new Food(menuItemName, menuItemPrice, menuItemDescription);
        menuItemController.createMenuItem(restaurant, foodItem);
    }


    public void updateMenuItem(Restaurant restaurant, Menu menu, MenuItemInterface menuItem){
        //updates menu item
        System.out.println("What is the name of the menu item?");
        String menuItemName = scanner.nextLine();
        System.out.println("What is the description of the menu item?");
        String menuItemDescription = scanner.nextLine();
        System.out.println("What is the price?");
        Double menuItemPrice = scanner.nextDouble();
        System.out.println("Menu item is being updated...");
        Food foodItem = new Food(menuItemName, menuItemPrice, menuItemDescription);
        menuItemController.updateMenuItem(menuItem, foodItem);
    }

    public void removeMenuItem(Restaurant restaurant, Menu menu, MenuItemInterface menuItem){
        //removes menu item
        menuItemController.removeMenuItem(restaurant, menuItem);
        System.out.println("Menu item is being removed...");
    }
}
