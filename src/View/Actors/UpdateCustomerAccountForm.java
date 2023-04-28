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
    private JLabel lbl_firstName, lbl_OGFirstName;
    private JLabel lbl_lastName;
    private JLabel lbl_address;
    private JTextField txt_firstName, txt_lastName, txt_address, txt_banner;
    private JButton btn_update, btn_back;
    private Customer customer = new Customer();
    private CustomerController customerController = new CustomerController();

    public UpdateCustomerAccountForm() throws IOException {
        initCompts();
    }
    public UpdateCustomerAccountForm(Customer customer) throws IOException {
        this.customer = customer;
        initCompts();
    }

    private void initCompts(){
        setTitle("Update Account Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        lbl_OGFirstName = new JLabel();
        lbl_firstName = new JLabel();
        lbl_lastName = new JLabel();
        lbl_address = new JLabel();
        txt_firstName = new JTextField(15);
        txt_lastName = new JTextField(15);
        txt_address = new JTextField(15);
        txt_banner = new JTextField(20);
        lbl_OGFirstName.setText(customer.getFirstName());
        lbl_firstName.setText("Enter your new first name");
        lbl_lastName.setText("Enter your new last name");
        lbl_address.setText("Enter your new address");

        btn_update = new JButton();
        btn_update.setText("Update");
        btn_back = new JButton();
        btn_back.setText("Back");

        txt_firstName.addActionListener(this);
        txt_lastName.addActionListener(this);
        txt_address.addActionListener(this);
        btn_update.addActionListener(this);
        btn_back.addActionListener(this);

        updateAccountView.add(lbl_OGFirstName);
        updateAccountView.add(lbl_firstName);
        updateAccountView.add(txt_firstName);
        updateAccountView.add(lbl_lastName);
        updateAccountView.add(txt_lastName);
        updateAccountView.add(lbl_address);
        updateAccountView.add(txt_address);
        updateAccountView.add(btn_update);
        updateAccountView.add(txt_banner);
        updateAccountView.add(btn_back);

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
                    customerController.updateCustomerAccount(firstName, lastName, address, customer.getFirstName());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                txt_banner.setText("Your account has been updated");
            }
            else txt_banner.setText("Invalid input, try again");

        }
        if (e.getSource() == btn_back){
            setVisible(false);
            try {
                CustomerOrderView customerOrderView = new CustomerOrderView(customer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private boolean validateData(String firstName, String lastName, String address){
        return !firstName.equals("") && !lastName.equals("") && !address.equals("");
    }
}
