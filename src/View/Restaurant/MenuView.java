package View.Restaurant;

import Controller.Actors.CustomerController;
import Controller.Restaurant.OrderController;
import Controller.Restaurant.RestaurantController;
import Model.Actors.Customer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Food;
import Model.Restaurant.Restaurant;
import View.ShoppingCartView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Scanner;
import java.util.Vector;

public class MenuView extends JFrame implements ActionListener{
    private JPanel menuView = new JPanel();
    private JTable menuTable;
    private DefaultTableModel menuTableModel;
    private JLabel menuLabel;
    private JScrollBar menuScroller;
    private JButton btn_order;
    private RestaurantController restaurantController = new RestaurantController();
    private Restaurant restaurant1;
    private Customer customer;
    private CustomerController customerController;
    private RestaurantOwner restaurantOwner;

    public MenuView(Restaurant restaurant, Customer customer){
        initCompts();
        restaurant1 = restaurant;
        this.customer = customer;

    }

    public MenuView(RestaurantOwner restaurantOwner, Restaurant restaurant){
        initCompts();
        restaurant1 = restaurant;
        this.restaurantOwner = restaurantOwner;
    }
    public MenuView (){
        initCompts();
    }

    public void initCompts(){
            setTitle("Menu");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);
            setLocationRelativeTo(null);

            menuTableModel = new DefaultTableModel();
            menuTableModel.addColumn("Item");
            menuTableModel.addColumn("Description");
            menuTableModel.addColumn("Price");
            menuTable = new JTable(menuTableModel);
            JScrollPane menuScrollPane = new JScrollPane(menuTable);
            menuLabel = new JLabel("Menu");
            menuScroller = new JScrollBar();
            menuView.add(menuScroller);

            JPanel buttonPanel = new JPanel();
            btn_order = new JButton("Select to Order");
            buttonPanel.add(btn_order);
            btn_order.addActionListener(this);

            add(menuScrollPane, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            add(menuLabel, BorderLayout.NORTH);

            menuScroller.addAdjustmentListener(new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    Double currHeightSize = menuScroller.getMaximumSize().getHeight();
                    Double currWidthSize = menuScroller.getMaximumSize().getWidth();
                    currHeightSize = currHeightSize + 10;
                    while (e.getValueIsAdjusting()) {
                        menuScroller.getMaximumSize().setSize(currWidthSize, currHeightSize);
                    }
                }
            });

            setVisible(false);
        }

    public void showMenu (Restaurant restaurant){
        menuLabel.setText(restaurant.getRestaurantName());
        for (Food item: restaurant.getFoodOptions().getMenuItemsList()){
            Vector row = new Vector();
            row.add(item.name());
            row.add(item.getDescription());
            row.add(item.getPrice());
            menuTableModel.addRow(row);
        }
        this.setVisible(true);
    }

    public int getOrder(){
        int row = 0;
        row = menuTable.getSelectedRow();
        int order = menuTable.convertRowIndexToModel(row);
        if (order < 0){
            order = 0;
        }
        return order;
    }

    public void showMenuToRestaurant(Restaurant restaurant){
        //shows restaurant menu
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_order){
            int orderItem = getOrder();
            this.restaurantController.orderItem(restaurant1, customer, orderItem);
        }
    }
}
