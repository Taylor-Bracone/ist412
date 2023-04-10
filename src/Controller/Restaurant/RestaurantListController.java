package Controller.Restaurant;

import Model.Actors.RestaurantOwner;
import Model.Restaurant.Food;
import Model.Restaurant.Menu;
import Model.Restaurant.Restaurant;

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

    public void removeRestaurantFromList(Restaurant restaurant){
        //removes restaurant from the list
    }

    public ArrayList<Restaurant> viewRestaurantList(){
        createList();
        return restaurantList;
    }

    private ArrayList<Restaurant> createList(){
        ArrayList<Food> menuItems1 = new ArrayList<>();
        Food item = new Food("Tacos", 12.00, "Chicken Tacos", null, null);
        Food item2 = new Food("Fish", 10.00, "Blue Fish", null, null);
        menuItems1.add(item);
        menuItems1.add(item2);
        Menu menu = new Menu("Menu1", menuItems1);
        Restaurant r1 = new Restaurant("Restaurant1", new RestaurantOwner("Kim", "Winters", "123", "123"),
                123, 123, "email", menu);

        restaurantList.add(r1);

        return restaurantList;
    }
}
