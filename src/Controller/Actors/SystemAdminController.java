package Controller.Actors;

import Model.Actors.Customer;
import Model.Restaurant.Restaurant;

public class SystemAdminController {

    public void viewRestaurantList(){
        //sysAdmin can see all restaurants in the list
    }

    public void removeRestaurantFromList(Restaurant restaurantToRemove){
        //sysAdmin removes restaurant from the list
    }

    public void addRestaurantToList(Restaurant restaurantToAdd){
        //sysAdmin adds new restaurant to the list, from the pending restaurant list
    }

    public void viewCustomerList(){
        //sysAdmin see the entire customer list
    }

    public void removeCustomer(Customer customer){
        //sysAdmin removes customer from list, so customer can no longer log in
    }

}
