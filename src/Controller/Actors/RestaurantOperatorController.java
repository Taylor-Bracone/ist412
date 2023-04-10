package Controller.Actors;

import Model.Actors.RestaurantOperator;
import Model.Restaurant.Restaurant;

public class RestaurantOperatorController {
    /**
     * Handles logic for the restaurant operator
     * @param restaurant
     */
    public void viewListOfOrders(Restaurant restaurant){
        //gets list of pending orders
    }

    public void viewQueueOfDeliverers(RestaurantOperator restaurantOperator){
        //gets list of deliverers ready to deliver
    }

    public void viewCompletedOrders(Restaurant restaurant){
        //gets list of a restaurant's completed orders
    }
}
