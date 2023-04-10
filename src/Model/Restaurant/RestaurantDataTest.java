package Model.Restaurant;

import Model.Actors.Customer;
import Model.Actors.User;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

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