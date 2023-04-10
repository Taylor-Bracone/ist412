package Model.Actors;

import Model.Restaurant.Menu;
import Model.Restaurant.MenuItem;
import Model.Restaurant.Restaurant;

public class RestaurantOwner extends User{
    private Restaurant restaurant;
    private String restaurantOwnerID;

    /**
     * Used to establish an Actors.User object
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     */
    public RestaurantOwner(String firstName, String lastName, String address, String phoneNumber, Restaurant restaurant) {
        super(firstName, lastName, address, phoneNumber);
        this.restaurant = restaurant;
    }
    public RestaurantOwner(User user, String userName){
        super(user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhoneNumber());
        this.restaurantOwnerID = userName;
    }


    public RestaurantOwner(String firstName, String lastName, String address, String phoneNumber){
        super(firstName, lastName, address, phoneNumber);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu createMenu (Menu newMenu, Restaurant restaurant){
        //creates new menu for their restaurant
        return null;
    }

    public void addMenuItem (Menu menu, Restaurant restaurant, MenuItem menuItem){
        //adds new menu item to existing menu
    }

    public void updateMenuItem(Menu menu, Restaurant restaurant, MenuItem menuItem){
        //updates menu item
    }

    public void removeMenuItem(Menu menu, Restaurant restaurant, MenuItem menuItem){
        //remove menu item from menu
    }

    public void removeMenu (Menu menu, Restaurant restaurant){
        //remove menu from restaurant
    }
}
