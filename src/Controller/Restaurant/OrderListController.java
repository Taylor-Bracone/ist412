package Controller.Restaurant;

import Model.Actors.Customer;
import Model.Actors.Deliverer;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import View.Restaurant.OrderListView;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderListController {
    private OrderListView orderListView;

    public void addOrderToQueue(Order order){
        //add order to a queue of current orders
    }

    public void removeOrderFromQueue(Order order){
        // searches the queue for the specified order
        // removes order from the queue
    }

    public void clearQueue(){
        // empties the order list
    }

    public void viewOrderList(){
        // shows view of the current orders
        this.orderListView = new OrderListView();
        // Display pending orders in the view
        orderListView.listCurrentOrders(OrderList.getOrderList());
    }

    public Customer customer1 = new Customer("Andrew", "Ho", "539 Gloria Lane", "4412420683", "39122");
    public Order order1 = new Order(customer1, customer1.restaurant1);
    public Deliverer deliverer1 = new Deliverer( "2303");


//    public ArrayList<Order> readFromOrderListFile() throws IOException {
//        File orderListFile = new File("src/DataFiles/OrderList.txt");
//        BufferedReader bufReader = new BufferedReader(new FileReader(orderListFile));
//        ArrayList<String> data = new ArrayList<>();
//        ArrayList<Order> orderList = new ArrayList<>();
//        String line = bufReader.readLine();
//        while (line != null) {
//            data.add(line);
//            line = bufReader.readLine();
//        }
//        bufReader.close();
//        int index = 0;
//        for (int i = 0; i < (data.size()/3); i++) {
//            Order order = new Order(customer1, order1, deliverer1);
//            orderList.add(order);
//            index = index + 6;
//        }
//        return orderList;
//    }

    public Map<String, List<String>> readFromOrder () throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        BufferedReader reader = null;
        File file = new File("src/DataFiles/Order.txt");
        reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null){
            String [] data = line.split(":");
            String key = data[0];
            String value = data[1];
            if (map.containsKey(key)){
                map.get(key).add(value);
            }
            else{
                map.put(key, Stream.of(value).collect(Collectors.toList()));
            }
        }

        return map;
    }

    public ArrayList<String> orderHistory (String customerName) throws IOException {
        Map<String, List<String>> map = readFromOrder();
        ArrayList<String> name = new ArrayList<>(map.get("customer"));
        ArrayList<String> itemOrdered = new ArrayList<>(map.get("item"));
        ArrayList<String> order = new ArrayList<>();
        for (int i = 0; i < name.size(); i++){
            if (name.get(i).equals(customerName)){
                order.add(itemOrdered.get(i));
            }
        }
        return order;

    }

    public void writeToOrder (String customerName, String item) throws IOException {
        File orderFile = new File("src/DataFiles/Order.txt");
        FileWriter  writer = new FileWriter(orderFile, true);
        StringBuilder text = new StringBuilder();
        text.append("customer:").append(customerName).append("\n");
        text.append("item:").append(item).append("\n");

        writer.write(text.toString());
        writer.close();

    }

}
