package Model.Actors;
import Model.Restaurant.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User implements Observer {
    private String customerID;
    private String password;
    private String userName;
    private ArrayList<Cuisine> preferredCuisines = new ArrayList<>();
    //cuisine would go here

    /**
     * Establishes the Actors.Customer object
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     * @param customerID
     */
    public Customer(String firstName, String lastName, String address, String phoneNumber, String customerID, String password) {
        super(firstName, lastName, address, phoneNumber);
        this.customerID = customerID;
        this.password = password;
    }

    public Customer(User user, String userName) {
        super(user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhoneNumber());
        this.userName = userName;
    }

    public Customer(){
        super();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public String getCustomerID() {
        return customerID;
    }
    public String getPassword(){
        return password;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * Creates an Restaurant.Order to associate to the Actors.Customer
     *
     * @param restaurant
     * @param food
     * @return order
     */
    public Order createOrder(Restaurant restaurant, String food) {
        //customer creates order
        return null;
    }

    public void setPreferredCuisine(Cuisine preferredCuisine) {
        this.preferredCuisines.add(preferredCuisine);
    }

    @Override
    public void update(RestaurantList rl) {
        ArrayList<Restaurant> myRestaurants = new ArrayList<>();
        for (int i = 0; i < this.preferredCuisines.size(); i++) {
            for (int j = 0; j < rl.getRestaurantList().size(); j++) {
                if (rl.getRestaurantList().get(j).getServingCuisines().contains(this.preferredCuisines.get(i)))
                    myRestaurants.add(rl.getRestaurantList().get(j));
            }
        }
        for (int i = 0; i < myRestaurants.size(); i++) {
            System.out.println(myRestaurants.get(i).getRestaurantName());
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getUserName()).append(getFirstName());
         return sb.toString();
    }

}


