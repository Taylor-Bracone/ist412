package View.Restaurant;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTabsView {

    public static void main(String[] args) {
        System.out.println("--swing tabs for the UI design pattern navigation--");

        //this is the screen that happens after login/ auth
        JFrame jFrame = new JFrame("OFO_Online Food Ordering Application");

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension d = new Dimension(800, 800);
        jFrame.setSize(d);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //zero tab item
        JPanel zeropanel = new JPanel();
        GridLayout gridLayout = new GridLayout(1,1);
        zeropanel.setLayout(gridLayout);
        //adding item for the zero tab
        JTextArea jTextArea0 = new JTextArea();
        zeropanel.add(jTextArea0);
        JButton submit0 = new JButton("Home");
        zeropanel.add(submit0);

        //first tab item
        JPanel firstpanel = new JPanel();
        GridLayout gridLayout0 = new GridLayout(1,1);
        firstpanel.setLayout(gridLayout0);
        //adding item for the first tab
        JTextArea jTextArea = new JTextArea();
        firstpanel.add(jTextArea);
        JButton submit = new JButton("Place an Order");
        firstpanel.add(submit);

        //second tab item
        JPanel secondpanel = new JPanel();
        GridLayout gridLayout2 = new GridLayout(1,1);
        secondpanel.setLayout(gridLayout2);
        //adding item for the second tab
        JTextArea jTextArea2 = new JTextArea();
        secondpanel.add(jTextArea2);
        JButton submit2 = new JButton("Request to be Added to Listing");
        secondpanel.add(submit2);

        //third tab item
        JPanel thirdpanel = new JPanel();
        GridLayout gridLayout3 = new GridLayout(1,1);
        thirdpanel.setLayout(gridLayout3);
        //adding item for the third tab
        JTextArea jTextArea3 = new JTextArea();
        thirdpanel.add(jTextArea3);
        JButton submit3 = new JButton("Add Menu Options");
        thirdpanel.add(submit3);

        //fourth tab item
        JPanel fourthpanel = new JPanel();
        GridLayout gridLayout4 = new GridLayout(1,1);
        fourthpanel.setLayout(gridLayout4);
        //adding item for the third tab
        JTextArea jTextArea4 = new JTextArea();
        fourthpanel.add(jTextArea4);
        JButton submit4 = new JButton("Delivery Status");
        fourthpanel.add(submit4);

        submit0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tab 0 "+ jTextArea0.getText());
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tab 1 "+ jTextArea.getText());
            }
        });

        submit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tab 2 "+ jTextArea2.getText());
            }
        });

        submit3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tab 3 "+ jTextArea3.getText());
            }
        });

        submit4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tab 4 "+ jTextArea4.getText());
            }
        });

        //start of the application after auth
        tabbedPane.add("Home", zeropanel);
        //first main use case place an order to a restaurant
        tabbedPane.add("Placing an Order", firstpanel);
        //request to be added to the restaurant list
        tabbedPane.add("Request to be Added to Listing", secondpanel);
        //adding menu options
        tabbedPane.add("Add Menu Options", thirdpanel);
        //accepting an order for delivery
        tabbedPane.add("Delivery Status", fourthpanel);


        tabbedPane.setTabPlacement(SwingConstants.LEFT);

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Active Tab Position : " + tabbedPane.getSelectedIndex());

            }
        });

        //starts past the home
        tabbedPane.setSelectedIndex(1);

        jFrame.add(tabbedPane);
        jFrame.setVisible(true);

    }
}
