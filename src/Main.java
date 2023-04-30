import Controller.Authentication.*;
import Model.Actors.*;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;
import Model.Restaurant.Restaurant;
import View.Actors.ResOwnerOptionsView;
import View.Restaurant.OrderListView;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // initialize lists
        OrderList orderList = new OrderList();
        DelivererList delivererList = new DelivererList();

        // Add current order to past order list for testing purposes
        AuthController ac = new AuthController();
       // OrderListView rs = new OrderListView();
    }
}