package Controller.Restaurant;

import Model.Restaurant.Food;
import Model.Restaurant.MenuItemInterface;
import Model.Restaurant.Restaurant;

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
    public MenuItemInterface createMenuItem(Restaurant restaurant, Food foodItem){
        //creates new menu item
        //ArrayList<Restaurant> restaurants = restaurantListController.viewRestaurantList();
        restaurant.getFoodOptions().getMenuItemsList().add(foodItem);
        return foodItem;
    }

    public void updateMenuItem(MenuItemInterface menuItem, Food foodItem){
        //updates menu item
        String menuItemName = menuItem.name();
        for(MenuItemInterface menuItemToCheck : restaurant.getFoodOptions().getMenuItemsList()){
            if(foodItem.equals(menuItemToCheck)){
                menuItemToCheck = foodItem;
                System.out.println("Menu item was updated.");
            }
        }
    }

    public void removeMenuItem(Restaurant restaurant, MenuItemInterface menuItemToRemove){
        //remove menu item
        restaurant.getFoodOptions().getMenuItemsList().remove(menuItemToRemove);
        System.out.println("Menu item was removed");
    }
}
