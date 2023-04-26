package View.Actors;

import Controller.Restaurant.OrderController;
import Model.Actors.Customer;
import Model.Restaurant.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CustomerOrderHistory extends JFrame implements ActionListener {

    private JPanel orderHistory = new JPanel();
    private JTable orderHistoryTable;
    private DefaultTableModel orderTableModel;
    private JButton btn_back;
    private Customer customer = new Customer();
    private OrderController orderController = new OrderController();
    public CustomerOrderHistory() throws IOException {
        intiCompts();
    }
    public CustomerOrderHistory(Customer customer) throws IOException {
        this.customer = customer;
        intiCompts();
    }

    private void intiCompts() throws IOException {
        setTitle("Customer Order History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        orderTableModel = new DefaultTableModel();
        orderTableModel.addColumn("Item Ordered");
        orderHistoryTable = new JTable(orderTableModel);
        JScrollPane orderScrollPane = new JScrollPane(orderHistoryTable);
        //ArrayList<String> list = populateTable(customer.getFirstName());
//        for (int i =0; i < list.size(); i++){
//            Vector row = new Vector();
//            row.add(i);
//            orderTableModel.addRow(row);
//        }

        JPanel buttonPanel = new JPanel();
        btn_back = new JButton("Back");
        buttonPanel.add(btn_back);

        add(orderHistory, BorderLayout.CENTER);
        add(orderScrollPane, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
