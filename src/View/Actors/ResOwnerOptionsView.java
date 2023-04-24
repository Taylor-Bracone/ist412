package View.Actors;

import Controller.Actors.CustomerController;
import Controller.Actors.RestaurantOwnerController;
import Model.Actors.Customer;
import Model.Actors.RestaurantOwner;
import Model.Restaurant.Restaurant;
import View.Restaurant.MenuView;
import View.Restaurant.RestaurantListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResOwnerOptionsView extends JFrame implements ActionListener {
    private RestaurantOwnerController resOwnerController = new RestaurantOwnerController();
    private MenuView menuView;
    private JPanel optionsView = new JPanel();
    private JList<String> optionsList;
    private JButton btn_select, btn_exit;
    private RestaurantOwner restaurantOwner;


    public ResOwnerOptionsView(RestaurantOwner restaurantOwner){
        initCompts();
        setVisible(true);
        this.restaurantOwner = restaurantOwner;
    }

    public void initCompts(){
        setTitle("Restaurant Owner Options View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        String[] options = {"View Menu", "Edit Menu"};
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

    private void switchView(int choice, RestaurantOwner restaurantOwner){
        setVisible(false);
        switch(choice) {
            case 0:
                Restaurant restaurant = restaurantOwner.getRestaurant();
                //resOwnerController.viewMenu(restaurant);
                //menuView = new MenuView(restaurantOwner, restaurant);
                break;

            case 1:
                //TODO
                break;

            case 2:
                System.out.println("Thank you!");
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_select){
            int index = optionsList.getSelectedIndex();
            //TODO
            //switchView(index, customer);
        }

        if (e.getSource() == btn_exit){
            System.exit(0);
        }
    }
}
