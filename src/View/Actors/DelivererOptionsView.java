package View.Actors;

import Controller.Actors.CustomerController;
import Controller.Actors.DelivererController;
import Model.Actors.Customer;
import Model.Actors.Deliverer;
import View.Restaurant.RestaurantListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelivererOptionsView extends JFrame implements ActionListener {

    //private DeliveryOrderListView = new DeliveryOrderListView();
    private JPanel optionsView = new JPanel();
    private JList<String> optionsList;
    private JButton btn_select, btn_exit;
    private Deliverer deliverer;
    private DelivererController delivererController = new DelivererController(deliverer);

    public DelivererOptionsView(Deliverer deliverer){
        initCompts();
        setVisible(true);
        this.deliverer = deliverer;
    }

    public void initCompts(){
        setTitle("Deliverer Options View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        String[] options = {"Display Assigned Order", "Display past orders"};
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

    private void switchView(int choice, Customer customer){
        setVisible(false);
        switch(choice) {
            case 0:
                delivererController.displayAssignedOrder(deliverer);
                break;

            case 1:
                delivererController.displayPastOrders(deliverer);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_select){
            int index = optionsList.getSelectedIndex();
            //switchView(index, ?);
        }

        if (e.getSource() == btn_exit){
            System.exit(0);
        }
    }
}
