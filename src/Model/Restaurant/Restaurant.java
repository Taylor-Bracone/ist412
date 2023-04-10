package Model.Restaurant;

import Model.Actors.Deliverer;
import Model.Actors.RestaurantOwner;

import java.util.ArrayList;

public class Restaurant {
    private String restaurantName;
    private RestaurantOwner restaurantOwnerName;
    private int restaurantID;
    private float restaurantContactNum;
    private String restaurantEmail;
    private Menu menu;
    private ArrayList<Deliverer> deliverers;
    //relate the cuisine choices
    private ArrayList<Cuisine> servingCuisines;
    /**
     *
     * @param restaurantName
     * @param restaurantOwnerName
     * @param restaurantID
     * @param restaurantContactNum
     * @param restaurantEmail
     * write something here
     */
    public Restaurant(String restaurantName){
        this.restaurantName = restaurantName;
        this.servingCuisines = new ArrayList<>();
    }
    public Restaurant(String restaurantName, RestaurantOwner restaurantOwnerName,
                      int restaurantID, float restaurantContactNum,
                      String restaurantEmail) {
        this.restaurantName = restaurantName;
        this.restaurantOwnerName = restaurantOwnerName;
        this.restaurantID = restaurantID;
        this.restaurantContactNum = restaurantContactNum;
        this.restaurantEmail = restaurantEmail;
        this.servingCuisines = new ArrayList<>();
    }

    public Restaurant(String restaurantName, RestaurantOwner restaurantOwnerName,
                      int restaurantID, float restaurantContactNum,
                      String restaurantEmail, Menu menu) {
        this.restaurantName = restaurantName;
        this.restaurantOwnerName = restaurantOwnerName;
        this.restaurantID = restaurantID;
        this.restaurantContactNum = restaurantContactNum;
        this.restaurantEmail = restaurantEmail;
        this.menu = menu;
        this.servingCuisines = new ArrayList<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public RestaurantOwner getRestaurantOwnerName() {
        return restaurantOwnerName;
    }

    public void setRestaurantOwnerName(RestaurantOwner restaurantOwnerName) {
        this.restaurantOwnerName = restaurantOwnerName;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public float getRestaurantContactNum() {
        return restaurantContactNum;
    }

    public void setRestaurantContactNum(float restaurantContactNum) {
        this.restaurantContactNum = restaurantContactNum;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    public Menu getFoodOptions() {
        return menu;
    }

    public void setFoodOptions(Menu menu) {
        this.menu = menu;
    }

    public void hireDeliver(){
        //adds delivery person to delivery person list
    }

    public ArrayList<Cuisine> getServingCuisines() {
        return servingCuisines;
    }

    public void setServingCuisines(Cuisine servingCuisine) {
        this.servingCuisines.add(servingCuisine);
    }
}
