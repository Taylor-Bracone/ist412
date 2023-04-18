package View.Actors;

import Controller.Actors.CustomerController;
import Controller.Authentication.AuthController;
import Controller.Restaurant.RestaurantController;
import Model.Actors.Customer;
import Model.Actors.User;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantList;
import View.Restaurant.RestaurantListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrderView extends JFrame implements ActionListener {
    private CustomerController customerController = new CustomerController();
    private RestaurantListView restaurantListView;
    private JPanel optionsView = new JPanel();
    private JList<String> optionsList;
    private JButton btn_select, btn_exit;
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
        buttonPanel.add(btn_select);
        buttonPanel.add(btn_exit);

        add(optionsView, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String orderFromRestaurant (){
        System.out.println("Pick a Restaurant name from the list above: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("You will order from: " + choice);
        return choice;
    }

    private void switchView(int choice, Customer customer){
        setVisible(false);
        switch(choice) {
            case 0:
                //TODO: use RestaurantListView here
                RestaurantListView restaurantListView = new RestaurantListView(customer);
                break;

            case 1:
                customerController.customerOrderHistory(customer);
                break;

            case 2:
                //TODO: make a new view for this
                System.out.println("Updating your account... ");
                System.out.println("Enter your first name: ");
                //String newFirstName = scanner.next();

                System.out.println("Enter your last name: ");
               // String newLastName = scanner.next();

                System.out.println("Enter your address: ");
                //String newAddress = scanner.next();

                //customerController.updateCustomerAccount(newFirstName, newLastName, newAddress);
                break;

            case 3:
                System.out.println("Viewing your current orders...");
                customerController.showRestaurantOrders(customer);
                break;
            case 4:
                System.out.println("Thank you!");
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_select){
            int index = optionsList.getSelectedIndex();
            switchView(index, customer);
        }

        if (e.getSource() == btn_exit){
            System.exit(0);
        }
    }
}
