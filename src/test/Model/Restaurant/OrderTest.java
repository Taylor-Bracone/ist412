package test.Model.Restaurant;

import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Restaurant.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrderTest {

    Order order;
    Deliverer deliverer;
    Customer customer;
    Restaurant restaurant;
    MenuItem item1;
    MenuItem item2;
    ArrayList<MenuItem> items = new ArrayList<>();
    @BeforeEach
    void setUp(){
        // test data
        deliverer = new Deliverer("D-02", "Dwayne", "Hicks", "nowhere",
                "678-910-1112","Weyland", "DHicks", "password");
        customer = new Customer("Ellen","Ripley", "Olympia", "123-456-7890",
                "C-0003", "password");
        restaurant = new Restaurant("Nostromo");
        item1 = new MenuItem("Haddock", 10.99, "A very upsetting fish name");
        item2 = new MenuItem("Blue Milk", 3.49, "Star Wars should never have made this a thing");
        items.add(item1);
        items.add(item2);

        order = new Order(customer,restaurant, deliverer, items);

    }

    @Test
    void getDelivererName() {
        System.out.println(order.getDeliverer().getFirstName());
        Assertions.assertEquals("Dwayne", order.getDeliverer().getFirstName());
    }

    @Test
    void getDelivererID() {
        System.out.println(order.getDeliverer().getDelivererID());
        Assertions.assertEquals("D-02", order.getDeliverer().getDelivererID());
    }

    @Test
    void setGetStatus() {
        order.setStatus("pending");
        System.out.println(order.getStatus());
        Assertions.assertEquals("pending", order.getStatus());
    }

    @Test
    void setGetValidity() {
        order.setValidOrder(true);
        System.out.println(order.isValidOrder());
        Assertions.assertEquals(true, order.isValidOrder());
    }

    @Test
    void failValidity() {
        order.setValidOrder(false);
        System.out.println(order.isValidOrder());
        Assertions.assertNotEquals(true, order.isValidOrder());
    }

    @Test
    void readItems() {
        //System.out.println(order.listItems());
        System.out.println(order.toString());
        Assertions.assertEquals("Order{\n" +
                "customer= Ellen, \n" +
                "restaurant= Nostromo, \n" +
                "deliverer= D-02, \n" +
                "status= 'null', \n" +
                "isValidOrder= false, \n" +
                "items= \n" +
                "Haddock\t$10.99\n" +
                "\tA very upsetting fish name\n" +
                "Blue Milk\t$3.49\n" +
                "\tStar Wars should never have made this a thing\n" +
                "}",order.toString());
    }
}
