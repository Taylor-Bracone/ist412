import Controller.Authentication.*;
import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import Model.Restaurant.Restaurant;

public class Main {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();

        Customer customer = new Customer("Susan", "Test", "123 Main Street", "444-333-5555", "", "");
        RestaurantOwner restaurantOwner = new RestaurantOwner("Emily", "Test", "234 Town Square", "111-222-3333" );
        Restaurant restaurant = new Restaurant("Yallah",restaurantOwner, 123, "1112223333", "test@test.com");
        Deliverer deliverer = new Deliverer("Deliverer1", "Mark", "White", "567 Center Drive", "777-888-9999", "DeliveryCompany1");
        Order order = new Order(customer, restaurant);
        order.setDeliverer(deliverer); // deliverer should be assigned to order by SysAdmin
        orderList.addItem(order);

        // Add current order to past order list for testing purposes
        AuthController ac = new AuthController();

    }
}