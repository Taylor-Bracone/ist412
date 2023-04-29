package test;

import Model.Actors.Customer;
import Model.Actors.User;

import Model.Restaurant.Cuisine;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantDataTest {
    @Test
    public void testRestaurantUpdate(){
        User customer1 = new User("userName", "password");
        Customer cust = new Customer(customer1,"userName");
        Cuisine cu = new Cuisine(1, "testCuisine1");
        cust.setPreferredCuisine(cu);
        RestaurantList rl = new RestaurantList();
        rl.registerObserver(cust);
        Restaurant rNew = new Restaurant("RestaurantNew1");
        rNew.setServingCuisines(cu);
        rl.addRestaurantToList(rNew);
    }
}