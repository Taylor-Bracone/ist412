package View.Restaurant;

import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.Customer;
import Model.Actors.SysAdmin;
import Model.Actors.User;
import Model.Restaurant.Restaurant;
import View.Actors.CustomerOrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class RestaurantListView extends JFrame implements ActionListener {
   private JPanel optionsView = new JPanel();
   private JButton btn_select, btn_exit, btn_back;

   private JTable restaurantTable;
   private DefaultTableModel restaurantTableModel;
   private Customer customer;
   private RestaurantListController restaurantListController = new RestaurantListController();
   private RestaurantController restaurantController = new RestaurantController();

   public RestaurantListView() throws IOException {
      initCompts();
   }
   public RestaurantListView(Customer customer) throws IOException {
       this.customer = customer;
       initCompts();
   }
   public void initCompts() throws IOException {
      setTitle("Restaurant List");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(250, 250);
      setLocationRelativeTo(null);

      restaurantTableModel = new DefaultTableModel();
      restaurantTableModel.addColumn("Restaurant Index");
      restaurantTableModel.addColumn("Restaurant Name");
      restaurantTable = new JTable(restaurantTableModel);
      JScrollPane restScrollPane = new JScrollPane(restaurantTable);
      ArrayList<Restaurant> restList = restaurantListController.viewRestaurantList();
      restaurantListController.readFromMenuForFoodList();
      for (int i = 0; i < restList.size(); i++){
         Vector row = new Vector();
         row.add(i);
         row.add(restList.get(i).getRestaurantName());
         restaurantTableModel.addRow(row);
      }

      JPanel buttonPanel = new JPanel();
      btn_select = new JButton("Select");
      btn_select.addActionListener(this);
      btn_exit = new JButton("Exit");
      btn_exit.addActionListener(this);
      btn_back = new JButton("Back");
      btn_back.addActionListener(this);
      buttonPanel.add(btn_select);
      buttonPanel.add(btn_exit);
      buttonPanel.add(btn_back);

      add(optionsView, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
      add(restScrollPane, BorderLayout.NORTH);

      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btn_select){
         int row = restaurantTable.getSelectedRow();
         if (row < 0){
            row = 0;
         }
         Restaurant toOrderFrom = null;
         try {
            toOrderFrom = restaurantListController.viewRestaurantList().get(row);
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
         restaurantController.orderFromMenu(toOrderFrom, customer);
      }
      if (e.getSource() == btn_exit){
         System.exit(0);
      }

      if (e.getSource() == btn_back){
         setVisible(false);
         try {
            CustomerOrderView customerOrderView = new CustomerOrderView(this.customer);
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
      }
   }
}

