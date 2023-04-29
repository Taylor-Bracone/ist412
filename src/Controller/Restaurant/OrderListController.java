package Controller.Restaurant;

import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import View.Restaurant.OrderListView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
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
        orderListView.listPendingOrders(OrderList.getOrderList());
    }

    public Map<String, List<String>> readFromOrder () throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        BufferedReader reader = null;
        File file = new File("ist412/src/DataFiles/Order.txt");
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
        File orderFile = new File("ist412/src/DataFiles/Order.txt");
        FileWriter  writer = new FileWriter(orderFile, true);
        StringBuilder text = new StringBuilder();
        text.append("customer:").append(customerName).append("\n");
        text.append("item:").append(item).append("\n");

        writer.write(text.toString());
        writer.close();

    }

}
