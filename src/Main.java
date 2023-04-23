import Controller.Restaurant.OrderListController;
import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import Model.Restaurant.HistoricalOrderList;
import Model.Restaurant.Restaurant;

public class Main {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        HistoricalOrderList historicalOrderList = new HistoricalOrderList();

        RestaurantOwner restaurantOwner = new RestaurantOwner("Emily", "Test", "234 Town Square", "111-222-3333");
        Restaurant restaurant1 = new Restaurant("Yallah",restaurantOwner, 123, "111-222-3333", "yallah@test.com");
        Restaurant restaurant2 = new Restaurant("Snap",restaurantOwner, 456, "122-333-4444", "snap@test.com");
        Deliverer deliverer1 = new Deliverer("D-54321", "Mark", "White", "567 Center Drive", "777-888-9999", "DeliveryCompany1");
        Deliverer deliverer2 = new Deliverer("D-98765", "Ellen", "Abbey", "345 Center Drive", "645-112-1234", "DeliveryCompany2");

        // Create Customer1
        Customer customer1 = new Customer("Susan", "Anderson", "123 Main Street", "444-333-5555", 01);
        Order order1 = new Order(customer1, restaurant1);
        order1.setDeliverer(deliverer1); // deliverer should be assigned to order by SysAdmin
        order1.setStatus("Pending");
        orderList.addItem(order1);

        // Create Customer2
        Customer customer2 = new Customer("Jack", "Smith", "987 Beaver Avenue", "999-888-7777", 02);
        Order order2 = new Order(customer2, restaurant2);
        order2.setDeliverer(deliverer2); // deliverer should be assigned to order by SysAdmin
        order2.setStatus("Pending");
        orderList.addItem(order2);

        // Create Customer3
        Customer customer3 = new Customer("Hannah", "Suarez", "857 Main Street", "133-421-9876", 04);
        Order order3 = new Order(customer3, restaurant2);
        order3.setDeliverer(deliverer1); // deliverer should be assigned to order by SysAdmin
        order3.setStatus("Pending");
        orderList.addItem(order3);

        // Create Customer4
        Customer customer4 = new Customer("Jackie", "Eggen", "345 Main Street", "132-533-1344", 04);
        Order order4 = new Order(customer4, restaurant1);
        order4.setDeliverer(deliverer1); // deliverer should be assigned to order by SysAdmin
        order4.setStatus("Pending");
        orderList.addItem(order4);

        OrderListController orderListController = new OrderListController();
        orderListController.viewOrderList();

        // Add current order to past order list for testing purposes
        historicalOrderList.addItem(order1);
        historicalOrderList.addItem(order2);
        historicalOrderList.addItem(order3);
        historicalOrderList.addItem(order4);
    }
}
