package View.Restaurant;

import Controller.Restaurant.RestaurantController;
import Controller.Restaurant.RestaurantListController;
import Model.Actors.Customer;
import Model.Actors.SysAdmin;
import Model.Restaurant.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class RestaurantListView extends JFrame implements ActionListener {
   private JPanel optionsView = new JPanel();
   private JButton btn_select, btn_exit;

   private JTable restaurantTable;
   private DefaultTableModel restaurantTableModel;
   private Customer customer;
   private RestaurantListController restaurantListController = new RestaurantListController();

   public static void main(String[] args) {
      RestaurantListView restaurantListView = new RestaurantListView();
   }
   public RestaurantListView(){
      initCompts();
   }

   public void initCompts(){
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
      System.out.println(restList.get(0).getRestaurantName());
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
      buttonPanel.add(btn_select);
      buttonPanel.add(btn_exit);

      add(optionsView, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
      add(restScrollPane, BorderLayout.NORTH);

      setVisible(true);
   }

   public void sysAdminView(SysAdmin sysAdmin){
       //sysAdmin sees all restaurants registered in the system
   }

   public void sysAdminViewPending (SysAdmin sysAdmin){
       //sysAdmin sees all restaurants wanting to be added to system
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btn_select){
         //get restaurant selected
         //then switch views
      }
      if (e.getSource() == btn_exit){
         System.exit(0);
      }
   }
}

