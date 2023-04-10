package View.Restaurant;

import Controller.Actors.RestaurantOwnerController;
import Controller.Restaurant.MenuItemController;
import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.RestaurantOperator;
import Model.Actors.RestaurantOwner;
import Model.Actors.User;
import Model.Restaurant.Menu;
import Model.Restaurant.MenuItem;
import Model.Restaurant.MenuItem1;
import Model.Restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantOrderView {
    /**
     * Presents a list of functions that the restaurant owner can perform for a restaurant
     */

    private RestaurantOwnerController restaurantOwnerController = new RestaurantOwnerController();
    private RestaurantListController restaurantListController = new RestaurantListController();
    private RestaurantController restaurantController = new RestaurantController();
    private ArrayList<Restaurant> restaurants = restaurantListController.viewRestaurantList();
    private Menu menu;

    public RestaurantOrderView(User restaurantOwner) {
        System.out.println("Welcome to the Restaurant Order View.");
        System.out.println("Please select a function from the list by entering the associated number.");
        System.out.println("1. Request to be added to restaurant list on the app");
        System.out.println("2. Request to be removed from restaurant list");
        System.out.println("3. Add restaurant operator.");
        System.out.println("4. Add menu item.");
        System.out.println("5. Update menu item.");
        System.out.println("6. Delete menu item.");
        System.out.println("7. Exit application.");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                RestaurantOwner restaurantOwner1 = new RestaurantOwner(restaurantOwner, restaurantOwner.getUserName());
                System.out.println("Please provide the restaurant's name:");
                String restaurantName = scanner.next();
                int restaurantID = 1; //needs to be auto generated
                System.out.println("Please provide the restaurant's contact number.");
                float restaurantContactNum = scanner.nextFloat();
                System.out.println("Please provide the restaurant's email.");
                String restaurantEmail = scanner.next();
                Restaurant newRestaurant = new Restaurant(restaurantName, restaurantOwner1, restaurantID, restaurantContactNum, restaurantEmail);
                restaurantOwnerController.requestToBeAdded(newRestaurant);
                System.out.println("Your request to be added has been submitted. " +
                        "Our admins will respond to your request within 1-3 business days.");
                break;

            case 2:
                System.out.println("Please type the name of the restaurant you would like removed from the system.");
                String resName = scanner.next();
                for(Restaurant restaurant : restaurants){
                    if(resName.equals(restaurant.getRestaurantName())){
                        restaurantOwnerController.requestToBeRemoved(restaurant);
                        System.out.println("Your request to be removed has been submitted.");
                    }
                    else{
                        System.out.println("That restaurant name entered does not match any restaurants in our system.");
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("Please provide the first name of the operator:");
                String firstName = scanner.next();
                System.out.println("Please provide the last name of the operator:");
                String lastName = scanner.next();
                System.out.println("Please provide the address of the operator.");
                String address = scanner.next();
                System.out.println("Please provide the phone number of the operator.");
                String phoneNum = scanner.next();
                RestaurantOperator newOperator = new RestaurantOperator(firstName, lastName, address, phoneNum);
                restaurantOwnerController.addOperator(newOperator);
                break;

            case 4:
                Menu menu;
                System.out.println("Please provide the name of the restaurant you would like to add a menu item for:");
                String restaurantName2 = scanner.next();
                for (Restaurant r : restaurants) {
                    if (r.getRestaurantName().equals(restaurantName2)) {
                        menu = r.getFoodOptions();
                        restaurantOwnerController.addMenuItem(r, menu);
                    }
                }
                break;
            case 5:
                System.out.println("Please provide the name of the restaurant you would like to update a menu item for:");
                String restaurantName3 = scanner.next();
                restaurants = restaurantListController.viewRestaurantList();
                for (Restaurant r : restaurants){
                    if (r.getRestaurantName().equals(restaurantName3)) {
                        menu = r.getFoodOptions();
                        System.out.println("Please provide the menu item name:");
                        String menuItemName = scanner.next();
                        for (MenuItem1 menuItem : menu.getMenuItemsList()) {
                            if (menuItem.name().equals(menuItemName)) {
                                restaurantOwnerController.updateMenuItem(r, menu, menuItem);
                            }
                        }
                    }
                }
                break;
            case 6:
                System.out.println("Please provide the name of the restaurant you would like to remove a menu item for:");
                String restaurantName4 = scanner.next();
                for (Restaurant r : restaurants){
                    if (r.getRestaurantName().equals(restaurantName4)) {
                        menu = r.getFoodOptions();
                        System.out.println("Please provide the menu item name:");
                        String menuItemName = scanner.next();
                        for (MenuItem1 menuItem : menu.getMenuItemsList()) {
                            if (menuItem.name().equals(menuItemName)) {
                                restaurantOwnerController.removeMenuItem(r, menu, menuItem);
                            }
                        }
                    }
                }
                break;
            case 7:
                System.out.println("Thank you!");
                return;

        }

    }

}
