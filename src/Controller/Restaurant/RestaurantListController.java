package Controller.Restaurant;

import Model.Actors.RestaurantOwner;
import Model.Restaurant.*;

import java.util.ArrayList;

//TODO: add method signatures
public class RestaurantListController {

    private ArrayList<Restaurant> restaurantList;

    /**
     * Establishes the Restaurant.Restaurant List Controller
     * @param restaurantList
     */
    public RestaurantListController(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
    public RestaurantListController(){
        restaurantList = new ArrayList<>();
    }

    public void addRestaurantToList(Restaurant restaurant){
        //adds a restaurant to the list
    }

    public ArrayList<Restaurant> viewRestaurantList(){
        createList();
        return restaurantList;
    }

    private ArrayList<Restaurant> createList(){
        ArrayList<Food> menuItems1 = new ArrayList<>();
        Food item = new Food("Tacos", 12.00, "Chicken Tacos");
        Food item2 = new Food("Fish", 10.00, "Blue Fish");
        menuItems1.add(item);
        menuItems1.add(item2);
        Menu menu = new Menu("Menu1", menuItems1);
        Restaurant r1 = new Restaurant("Restaurant1", new RestaurantOwner("Kim", "Winters", "123", "123"),
                123, 123, "email", menu);

        restaurantList.add(r1);

        return restaurantList;
    }
}
