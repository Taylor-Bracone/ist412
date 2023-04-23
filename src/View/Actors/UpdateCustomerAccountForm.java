package View.Actors;

import Controller.Actors.CustomerController;
import Model.Actors.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateCustomerAccountForm extends JFrame implements ActionListener {
    private JPanel updateAccountView = new JPanel();
    private JLabel lbl_firstName;
    private JLabel lbl_lastName;
    private JLabel lbl_address;
    private JTextField txt_firstName, txt_lastName, txt_address, txt_banner;
    private JButton btn_update;
    private Customer customer = new Customer();
    private CustomerController customerController = new CustomerController();

    public static void main(String[] args) {
        UpdateCustomerAccountForm updateCustomerAccountForm = new UpdateCustomerAccountForm();
    }

    public UpdateCustomerAccountForm(){
        initCompts();
    }
    public UpdateCustomerAccountForm(Customer customer){
        initCompts();
        this.customer = customer;
    }

    private void initCompts(){
        setTitle("Update Account Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        lbl_firstName = new JLabel();
        lbl_lastName = new JLabel();
        lbl_address = new JLabel();
        txt_firstName = new JTextField(15);
        txt_lastName = new JTextField(15);
        txt_address = new JTextField(15);
        txt_banner = new JTextField(20);
        lbl_firstName.setText("Enter your first name");
        lbl_lastName.setText("Enter your last name");
        lbl_address.setText("Enter your address");

        btn_update = new JButton();
        btn_update.setText("Update");

        txt_firstName.addActionListener(this);
        txt_lastName.addActionListener(this);
        txt_address.addActionListener(this);
        btn_update.addActionListener(this);

        updateAccountView.add(lbl_firstName);
        updateAccountView.add(txt_firstName);
        updateAccountView.add(lbl_lastName);
        updateAccountView.add(txt_lastName);
        updateAccountView.add(lbl_address);
        updateAccountView.add(txt_address);
        updateAccountView.add(btn_update);
        updateAccountView.add(txt_banner);

        //txt_banner.setVisible(false);
        add(updateAccountView, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_update){
            String firstName = txt_firstName.getText();
            String lastName = txt_lastName.getText();
            String address = txt_address.getText();
            if(validateData(firstName, lastName, address)){
                try {
                    customerController.updateCustomerAccount(firstName, lastName, address);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                txt_banner.setText("Your account has been updated");
            }
            else txt_banner.setText("Invalid input, try again");

        }
    }

    private boolean validateData(String firstName, String lastName, String address){
        return !firstName.equals("") && !lastName.equals("") && !address.equals("");
    }
}
