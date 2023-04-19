package View.Actors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomerAccountForm extends JFrame implements ActionListener {
    private JPanel updateAccountView = new JPanel();
    private JLabel lbl_firstName;
    private JLabel lbl_lastName;
    private JLabel lbl_address;
    private JTextField txt_firstName, txt_lastName, txt_address;

    public static void main(String[] args) {
        UpdateCustomerAccountForm updateCustomerAccountForm = new UpdateCustomerAccountForm();
    }

    public UpdateCustomerAccountForm(){
        initCompts();
    }
    private void initCompts(){
        setTitle("Update Account Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);

        lbl_firstName.setText("Enter your first name");
        lbl_lastName.setText("Enter your last name");
        lbl_address.setText("Enter your address");
        updateAccountView.add(lbl_firstName);
        updateAccountView.add(lbl_lastName);
        updateAccountView.add(lbl_address);

        add(updateAccountView, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
