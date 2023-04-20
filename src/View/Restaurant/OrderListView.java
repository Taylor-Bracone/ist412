package View;

import Model.Actors.Deliverer;
import Model.Restaurant.Order;
import Model.Restaurant.OrderList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class OrderListView extends JFrame {
    private JTable orderListTable;
    private DefaultTableModel model;


    public OrderListView() {
        setTitle("Order List View");
        setLocationRelativeTo(null);

        // Initialize components
        model = new DefaultTableModel();
        model.addColumn("Customer Name");
        model.addColumn("Restaurant Name");
        model.addColumn("Deliverer ID");
        model.addColumn("Delivery Status");
        orderListTable = new JTable(model);
        JScrollPane orderListScrollPane = new JScrollPane(orderListTable);

        add(orderListScrollPane, BorderLayout.CENTER);

        orderListTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                component.setBackground(row % 2 == 0 ? Color.WHITE : new java.awt.Color(225, 246, 255));
                return component;
            }
        });

        orderListTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        setSize(500, 500);
        setVisible(true);
    }

    public void listPendingOrders(List<Order> orderList){
        // Create an iterator to traverse the elements of the order list. The Order in the angle brackets
        // is the type of object stored in the list
        Iterator<Order> orderIterator = orderList.iterator();

        // Use iterator to access the elements of the collection (orderList) using the hasNext() method
        while (orderIterator.hasNext()){
            Order order = orderIterator.next();
            if (order.getStatus().equalsIgnoreCase("pending")){
                model.addRow(new Object[]{order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName(),
                        order.getRestaurant().getRestaurantName(), order.getDeliverer().getDelivererID(), order.getStatus()});
            }
        }
        orderListTable.setModel(model);
        model.fireTableDataChanged();
    }

    public void listAvailableDeliverers(List<Deliverer> listOfDeliverers){
        //TODO: to be implemented
    }
}
