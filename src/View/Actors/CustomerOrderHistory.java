package View.Actors;

import Controller.Restaurant.OrderController;
import Controller.Restaurant.OrderListController;
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
    private OrderListController orderListController = new OrderListController();

    public CustomerOrderHistory(Customer customer) throws IOException {
        this.customer = customer;
        intiCompts();
    }

    private void intiCompts() throws IOException {
        setTitle("Customer Order History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 500);
        setLocationRelativeTo(null);

        orderTableModel = new DefaultTableModel();
        orderTableModel.addColumn("Item Ordered");
        orderHistoryTable = new JTable(orderTableModel);
        JScrollPane orderScrollPane = new JScrollPane(orderHistoryTable);
        ArrayList<String> list = orderListController.orderHistory(customer.getFirstName());
        for (int i =0; i < list.size(); i++){
            Vector row = new Vector();
            row.add(list.get(i));
            orderTableModel.addRow(row);
        }

        JPanel buttonPanel = new JPanel();
        btn_back = new JButton("Back");
        btn_back.addActionListener(this);
        buttonPanel.add(btn_back);

        add(orderHistory, BorderLayout.CENTER);
        add(orderScrollPane, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_back){
            setVisible(false);
            try {
                CustomerOrderView customerOrderView = new CustomerOrderView(customer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
