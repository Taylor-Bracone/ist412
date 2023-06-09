package Model.Actors;

import Model.Restaurant.Order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deliverer extends User {

    private String delivererID;
    private String deliveryCompany;
    private boolean availabilityStatus = true;
    private ArrayList<Order> orderArrayList = new ArrayList<Order>();

    /**
     * Establishes the Actors.Deliverer Object
     * @param delivererID
     * @param deliveryCompany
     */
    public Deliverer(String delivererID, String firstName, String lastName, String address, String phoneNumber,
                     String deliveryCompany, String userName, String password) {
        super(firstName, lastName, address, phoneNumber);
        this.delivererID = delivererID;
        this.deliveryCompany = deliveryCompany;
        super.setUserName(userName);
        super.setPassword(password);
    }

    public Deliverer(String delivererID, String firstName, String lastName, String address, String phoneNumber,
                     String deliveryCompany, String userName, String password, ArrayList<Order> orderArrayList) {
        super(firstName, lastName, address, phoneNumber);
        this.delivererID = delivererID;
        this.deliveryCompany = deliveryCompany;
        super.setUserName(userName);
        super.setPassword(password);
        this.orderArrayList = orderArrayList;
    }

    /**
     * construct a deliverer object
     *
     * @param user the logged-in user
     */

    public Deliverer(User user){
        super(user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhoneNumber());
        this.delivererID = user.getUserName();
    }

    public Deliverer(String delivererID){
        this.delivererID = delivererID;
    }

    /**
     *
     * @return delivererID
     */
    public String getDelivererID() {
        return delivererID;
    }

    /**
     * Sets the Actors.Deliverer's ID
     * @param delivererID
     */
    public void setDelivererID(String delivererID) {
        this.delivererID = delivererID;
    }

    /**
     *
     * @return delivererName
     */

    /**
     *
     * @return deliveryCompany
     */
    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    /**
     * Set's the delivery company related to the Actors.Deliverer
     * @param deliveryCompany
     */
    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }
}
