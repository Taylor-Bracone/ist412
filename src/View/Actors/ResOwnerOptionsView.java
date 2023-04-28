package View.Actors;

import Controller.Actors.CustomerController;
import Controller.Actors.RestaurantOwnerController;
import Model.Actors.Customer;
import Model.Actors.RestaurantOwner;
import Model.Actors.User;
import Model.Restaurant.Restaurant;
import View.Restaurant.MenuView;
import View.Restaurant.RestaurantListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ResOwnerOptionsView extends JFrame implements ActionListener {
    private RestaurantOwnerController resOwnerController = new RestaurantOwnerController();
    private MenuView menuView;
    private JPanel optionsView = new JPanel();
    private JList<String> optionsList;
    private JButton btn_select, btn_exit;
    private RestaurantOwner restaurantOwner;

    public ResOwnerOptionsView(RestaurantOwner restaurantOwner) throws IOException {
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

    private Restaurant getRestaurant(RestaurantOwner restaurantOwner) throws IOException {
        User user = new User();
        ArrayList<RestaurantOwner> list = user.readFromRestaurantOwnerFile();
        for (RestaurantOwner ro : list){
            if (restaurantOwner.getRestaurantOwnerID().equals(ro.getRestaurantOwnerID())){
                return ro.getRestaurant();
            }
        }
        return null;
    }
    private void switchView(int choice, RestaurantOwner restaurantOwner) throws IOException {
        setVisible(false);
        switch(choice) {
            case 0:
                Restaurant restaurant = this.getRestaurant(this.restaurantOwner);
                menuView = new MenuView(restaurantOwner,restaurant);
                menuView.showMenu(restaurant);
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
            try {
                switchView(index, restaurantOwner);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == btn_exit){
            System.exit(0);
        }
    }
}
