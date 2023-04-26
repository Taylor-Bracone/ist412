package test.Controller.Actors;

import Controller.Actors.DelivererController;
import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Order;
import Model.Restaurant.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DelivererControllerTest {

    DelivererController controller = new DelivererController();
    Deliverer deliverer;
    Customer customer1;
    RestaurantOwner restaurantOwner1;
    Restaurant restaurant1;
    Order order1;
    Customer customer2;
    RestaurantOwner restaurantOwner2;
    Restaurant restaurant2;
    Order order2;
    ArrayList<Order> orderArrayList = new ArrayList<>();
    @BeforeEach
    void setUp(){
        deliverer = new Deliverer("D-01", "Jennete", "Vasquez", "123 Amitty Parkway",
                "555-555-5555", "ExpressEats", "username", "password");
        customer1 = new Customer("Sally", "Park", "452 Avenue", "1244244424", "522", "password" );
        restaurantOwner1 = new RestaurantOwner("John", "Smith", "142 Lane", "1241932253");
        restaurant1 = new Restaurant("Kimchi", restaurantOwner1, 1253, "4436914522", "restEmail");
        order1 = new Order(customer1, restaurant1, deliverer);
        customer2 = new Customer("Ellen", "Ripley", "123 Xeno St", "222-222-2222", "546", "password" );
        restaurantOwner2 = new RestaurantOwner("Newt", "Jorden", "02 Bishop Rd", "333-333-3333");
        restaurant2 = new Restaurant("Lambert's", restaurantOwner2, 1015, "444-444-4444", "rest2Email");
        order2 = new Order(customer2, restaurant2,deliverer);
        orderArrayList.add(order1);
        orderArrayList.add(order2);
    }

    @Test
    void displayAssignedOrder() {
        String expectedVal = "Details of Your Assigned Delivery: \n" +
                "Customer Name: Sally Park\n" +
                "Customer Address: 452 Avenue\n" +
                "Customer Phone Number: 1244244424\n" +
                "Details of Your Assigned Delivery: \n" +
                "Customer Name: Ellen Ripley\n" +
                "Customer Address: 123 Xeno St\n" +
                "Customer Phone Number: 222-222-2222";
        System.out.println(orderArrayList.toString());
        controller.displayAssignedOrder(deliverer, orderArrayList);
    }

    @Test
    void displayPastOrders() {
    }
}