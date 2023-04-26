package View;

import Controller.Restaurant.OrderController;
import Model.Actors.Customer;
import Model.Restaurant.Food;
import Model.Restaurant.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class ShoppingCartView extends JFrame implements ActionListener {
    private JTable cartTable;
    private DefaultTableModel cartTableModel;
    private JButton addButton, removeButton, checkoutButton;
    private JLabel totalLabel;
    private OrderController orderController = new OrderController();
    private Customer customer = new Customer();
    private Restaurant restaurant = new Restaurant();
    private Food food = new Food();

    public ShoppingCartView(Customer customer, Restaurant restaurant, Food item) {
        setTitle("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Initialize components
        cartTableModel = new DefaultTableModel();
        cartTableModel.addColumn("Product");
        cartTableModel.addColumn("Price");
        cartTableModel.addColumn("Quantity");
        cartTable = new JTable(cartTableModel);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);

        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        checkoutButton = new JButton("Checkout");
        totalLabel = new JLabel("Total: $0.00");

        // Add components to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(checkoutButton);

        add(cartScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(totalLabel, BorderLayout.NORTH);

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        checkoutButton.addActionListener(this);

        setVisible(true);
        this.customer = customer;
        this.restaurant = restaurant;
        this.food = item;
    }

    public void addToCart(Food item){
        Vector name = new Vector<>();
        name.add(item.getName());
        name.add(item.getDescription());
        name.add(item.getPrice());
        cartTableModel.addRow(name);
        totalLabel.setText("Total: $" + item.getPrice());
        JOptionPane.showMessageDialog(this, "Item added to cart.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        if (e.getSource() == addButton) {
            //Implement the add button functionality
        */
        if (e.getSource() == removeButton) {
            //Implement the remove button functionality
        } else if (e.getSource() == checkoutButton) {
            //orderController.generateOrder(customer.getFirstName(), restaurant.getRestaurantName(), food.getName());
            int numRows = cartTableModel.getRowCount();
            for (int i = 0; i < numRows; i++){
                cartTableModel.removeRow(i);
            }
            totalLabel.setText("Order was placed");
        }
    }

}
