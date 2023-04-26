package test.Model.Actors;

import Model.Actors.Customer;
import Model.Actors.RestaurantOwner;
import Model.Actors.User;
import Model.Restaurant.Cuisine;
import Model.Restaurant.Order;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer1;
    Customer customer2;
    User user1;
    RestaurantOwner restaurantOwner1;
    Restaurant restaurant1;
    Order order1;
    Cuisine cuisine1;
    RestaurantList restaurantList1;

    @BeforeEach
    void setUp(){
        // test data
        user1 = new User("Customer1","password");
        customer1 = new Customer(user1,"Customer1");
        customer2 = new Customer("Sally", "Park", "452 Avenue", "1244244424", "522", "password" );
        restaurantOwner1 = new RestaurantOwner("John", "Smith", "142 Lane", "1241932253");
        restaurant1 = new Restaurant("Canyon", restaurantOwner1, 1253, "4436914522", "restEmail");
        order1 = new Order(customer1, restaurant1);
        cuisine1 = new Cuisine(230, "Mexican");
        restaurantList1 = new RestaurantList();

        restaurant1.setServingCuisines(cuisine1);
    }

    @Test
    void getUserName() {
        String expectedVal = "Customer1";
        String actualVal = customer1.getUserName();

        Assertions.assertEquals(expectedVal, actualVal);
    }

    @Test
    void getPassword() {
        String expectedVal = "password";
        String actualVal = user1.getPassword();

        Assertions.assertEquals(expectedVal, actualVal);
    }

    @Test
    void setCustomerID() {
        String expectedVal = "522";
        customer2.setCustomerID(expectedVal);

        String actualVal = customer2.getCustomerID();
        Assertions.assertEquals(expectedVal, actualVal);
    }


    @Test
    void getCustomerID() {
        String expectedVal = "522";
        String actualVal = customer2.getCustomerID();

        Assertions.assertEquals(expectedVal, actualVal);
    }

    @Test
    void createOrder() {
        Order order = customer2.createOrder(customer1, restaurant1);

        Assertions.assertNotNull(order);
    }

    @Test
    void update() {
        String expectedVal = "Canyon";
        restaurantList1.addRestaurantToList(restaurant1);

        customer2.setPreferredCuisine(cuisine1);
        // updates customer's "MyRestaurant" list
        customer2.update(restaurantList1);

        Assertions.assertEquals(expectedVal,customer2.getMyRestaurants().get(0).getRestaurantName());
    }
}