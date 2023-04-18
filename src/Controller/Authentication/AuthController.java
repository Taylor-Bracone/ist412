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
import Model.Restaurant.PastOrderList;
import View.Actors.AuthenticationView;
import View.AuthView;

import java.util.ArrayList;
import java.util.List;

public class AuthController {
    private OrderList orderList;
    private PastOrderList pastOrderList;
    private User user;
    private AuthView authView;
    CustomerController customerController;
    RestaurantOwnerController restaurantOwnerController;
    DelivererController delivererController;

    public AuthController(){
        this.authView = new AuthView(this);
    }

    public void login(User user){
        String verifiedUser = user.verifyUser();
        if (verifiedUser.equals("Customer")){
            Customer customer = new Customer(user, user.getUserName());
            this.customerController = new CustomerController(customer);
        } else if(verifiedUser.equals("Restaurant Owner")){
            RestaurantOwner restaurantOwner = new RestaurantOwner(user, user.getUserName());
            this.restaurantOwnerController = new RestaurantOwnerController(user);
        } else if(verifiedUser.equals("Deliverer")){
            Deliverer deliverer = new Deliverer(user);
            this.delivererController = new DelivererController(deliverer);
        }
        else{
            System.out.println("Invalid login");
            this.authView = new AuthView(this);
        }

    }

}
