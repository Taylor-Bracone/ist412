package Controller.Restaurant;

import Model.Restaurant.Food;
import Model.Restaurant.MenuItem;
import Model.Restaurant.MenuItem1;
import Model.Restaurant.Restaurant;

import java.util.ArrayList;

public class MenuItemController {
    /**
     *
     * MenuItem Controller has all logic to add/update/delete a menu item
     */

    private RestaurantController restaurantController;
    private RestaurantListController restaurantListController;
    private Restaurant restaurant;
    /*
    public void updateName(MenuItem menuItem, String newName){
        //updates name of menu item

    }

    public void updatePrice(double newPrice){
        //updates price of menu item

    }

    public void updateDescription(String newDescription){
        //update description
    }
*/
    public MenuItem1 createMenuItem(Restaurant restaurant, String name, String description, double price){
        //creates new menu item
        //ArrayList<Restaurant> restaurants = restaurantListController.viewRestaurantList();
        Food menuItem = new Food(name, price, description, null, null);
        restaurant.getFoodOptions().getMenuItemsList().add(menuItem);
        return menuItem;
    }

    public void updateMenuItem(MenuItem1 menuItem, String name, String description, double price){
        //updates menu item
        String menuItemName = menuItem.name();
        for(MenuItem1 menuItemToCheck : restaurant.getFoodOptions().getMenuItemsList()){
            if(menuItem.equals(menuItemToCheck)){
                menuItemToCheck = menuItem;
                System.out.println("Menu item was updated.");
            }
        }
    }

    public void removeMenuItem(Restaurant restaurant, MenuItem1 menuItemToRemove){
        //remove menu item
        restaurant.getFoodOptions().getMenuItemsList().remove(menuItemToRemove);
        System.out.println("Menu item was removed");
    }
}
