package Model.Actors;
import Model.Restaurant.*;

import java.util.ArrayList;

public class Customer extends User implements Observer {
    private int customerID;
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
    public Customer(String firstName, String lastName, String address, String phoneNumber, int customerID) {
        super(firstName, lastName, address, phoneNumber);
        this.customerID = customerID;
    }

    public Customer(User user, String userName) {
        super(user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhoneNumber(), user.getID());
        this.userName = userName;
    }

    /**
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the Actors.Customer's ID
     *
     * @param customerID
     */
    public void setCustomerID(int customerID) {
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
}


