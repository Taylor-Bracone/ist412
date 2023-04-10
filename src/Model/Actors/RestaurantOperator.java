package Model.Actors;
import Model.Restaurant.Order;

public class RestaurantOperator extends User {
    /**
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     * Accepts or declines an order
     */
    public RestaurantOperator(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName, address, phoneNumber);
    }

    public boolean acceptsOrder(Order orderID){
        return false;
    }
}
