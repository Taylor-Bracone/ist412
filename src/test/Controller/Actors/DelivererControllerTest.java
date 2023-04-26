package test.Controller.Actors;

import Model.Actors.Customer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Order;
import Model.Restaurant.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererControllerTest {

    Customer customer1;
    RestaurantOwner restaurantOwner1;
    Restaurant restaurant1;
    Order order1;
    @BeforeEach
    void setUp(){
        customer1 = new Customer("Sally", "Park", "452 Avenue", "1244244424", "522", "password" );
        restaurantOwner1 = new RestaurantOwner("John", "Smith", "142 Lane", "1241932253");
        restaurant1 = new Restaurant("Kimchi", restaurantOwner1, 1253, "4436914522", "restEmail");
        order1 = new Order(customer1, restaurant1);
    }

    @Test
    void displayAssignedOrder() {
        String expectedVal = "lindaR42";
        //String actualVal = order1.getUserName();

       // Assertions.assertEquals(expectedVal, actualVal);
    }

    @Test
    void displayPastOrders() {
    }
}