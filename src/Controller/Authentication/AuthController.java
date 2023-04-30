package Controller.Authentication;

import Controller.Actors.CustomerController;
import Controller.Actors.DelivererController;
import Controller.Actors.RestaurantOwnerController;
import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Actors.RestaurantOwner;
import Model.Actors.User;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import Model.Restaurant.Restaurant;
import View.AuthView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AuthController {
    private AuthView authView;
    CustomerController customerController;
    RestaurantOwnerController restaurantOwnerController;
    DelivererController delivererController;
    ArrayList<Order> orderList = new ArrayList<>();

    public AuthController(){
        this.authView = new AuthView(this);
    }

    public void login(User user) throws IOException {
        String verifiedUser = user.verifyUser();
        if (verifiedUser.equals("Customer")){
            Customer customer = user.getCustomer(user.getUserName());
            this.customerController = new CustomerController(customer);
        }
        else if(verifiedUser.equals("Restaurant Owner")){
            RestaurantOwner restaurantOwner = new RestaurantOwner(user, user.getUserName());
            this.restaurantOwnerController = new RestaurantOwnerController(restaurantOwner);
        }
        else if(verifiedUser.equals("Deliverer")){
            Deliverer deliverer = user.readFromDelivererFile().get(0);
            Customer customer = user.readFromCustomerFile().get(0);

            RestaurantOwner restaurantOwner = new RestaurantOwner("Emily", "Test", "234 Town Square", "111-222-3333" );
            Restaurant restaurant = new Restaurant("Yallah",restaurantOwner, 123, "1112223333", "test@test.com");

            Order order = new Order(customer, restaurant);
            order.setDeliverer(deliverer);
            order.setStatus("pending");
            orderList.add(order);

            this.delivererController = new DelivererController(deliverer);
        }
        else{
            System.out.println("Invalid login");
            this.authView = new AuthView(this);
        }

    }

}
