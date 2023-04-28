package View.Actors;

import Controller.Actors.CustomerController;
import Controller.Authentication.AuthController;
import Controller.Restaurant.RestaurantController;
import Model.Actors.Customer;
import Model.Actors.User;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantList;
import View.AuthView;
import View.Restaurant.RestaurantListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrderView extends JFrame implements ActionListener {
    private CustomerController customerController = new CustomerController();
    private RestaurantListView restaurantListView;
    private JPanel optionsView = new JPanel();
    private JList<String> optionsList;
    private JButton btn_select, btn_exit, btn_logOut;
    private Customer customer;

    public CustomerOrderView(Customer customer){
        initCompts();
        setVisible(true);
        this.customer = customer;
    }

    public void initCompts(){
        setTitle("Customer Options View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        String[] options = {"Place Order", "See Order History", "Update your account", "See your active orders"};
        optionsList = new JList<>(options);
        optionsView.add(optionsList);

        JPanel buttonPanel = new JPanel();
        btn_select = new JButton("Select");
        btn_select.addActionListener(this);
        btn_exit = new JButton("Exit");
        btn_exit.addActionListener(this);
        btn_logOut = new JButton("Log Out");
        btn_logOut.addActionListener(this);
        buttonPanel.add(btn_select);
        buttonPanel.add(btn_exit);
        buttonPanel.add(btn_logOut);

        add(optionsView, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void switchView(int choice, Customer customer) throws IOException {
        setVisible(false);
        switch(choice) {
            case 0:
                RestaurantListView restaurantListView = new RestaurantListView(customer);
                break;

            case 1:
                customerController.customerOrderHistory(this.customer);
                break;

            case 2:
                UpdateCustomerAccountForm updateCustomerAccountForm = new UpdateCustomerAccountForm(this.customer);

                break;

            case 3:
                System.out.println("Viewing your current orders...");
                customerController.showRestaurantOrders(customer);
                break;
            case 4:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_select){
            int index = optionsList.getSelectedIndex();
            try {
                switchView(index, customer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == btn_exit){
            System.exit(0);
        }

        if (e.getSource() == btn_logOut){
            setVisible(false);
            AuthController authController = new AuthController();
            AuthView authView = new AuthView(authController);
        }
    }
}
