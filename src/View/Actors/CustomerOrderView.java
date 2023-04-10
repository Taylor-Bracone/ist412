package View.Actors;

import Controller.Actors.CustomerController;
import Controller.Authentication.AuthController;
import Controller.Restaurant.RestaurantController;
import Model.Actors.Customer;
import Model.Actors.User;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantList;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrderView {

    private CustomerController customerController = new CustomerController();

    public CustomerOrderView(Customer customer){
        System.out.println("Welcome to the Customer Order View");
        System.out.println("Select A Functionality: ");
        System.out.println("1. Place Order");
        System.out.println("2. See Order History");
        System.out.println("3. Update your account");
        System.out.println("4. See your active orders");
        System.out.println("5. Exit Application");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch(option){
            case 1:
                System.out.println("Select Restaurant to Order from... ");
                customerController.viewRestaurantList();
                String restaurantName = orderFromRestaurant();
                customerController.placeOrder(restaurantName, customer);
                break;

            case 2:
                System.out.println("Your order history... ");
                customerController.customerOrderHistory(customer);
                break;

            case 3:
                System.out.println("Updating your account... ");
                System.out.println("Enter your first name: ");
                String newFirstName = scanner.next();

                System.out.println("Enter your last name: ");
                String newLastName = scanner.next();

                System.out.println("Enter your address: ");
                String newAddress = scanner.next();

                customerController.updateCustomerAccount(newFirstName, newLastName, newAddress);
                break;

            case 4:
                System.out.println("Viewing your current orders...");
                customerController.showRestaurantOrders(customer);
                break;
            case 5:
                System.out.println("Thank you!");
                break;
        }
    }

    public String orderFromRestaurant (){
        System.out.println("Pick a Restaurant name from the list above: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("You will order from: " + choice);
        return choice;
    }
}
