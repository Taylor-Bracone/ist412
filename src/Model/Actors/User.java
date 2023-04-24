package Model.Actors;

import Model.Restaurant.Restaurant;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
    /**
     * The Actors.User's first name
     */
    private String firstName;
    /**
     * The Actors.User's last name
     */
    private String lastName;
    /**
     * The Actors.User's address
     */
    private String address;
    /**
     * The Actors.User's phone number
     */
    public int ID;
    private String phoneNumber;
    private String userName;
    private String pswd;

    private String position;
    public User(String firstName, String lastName, String address, String phoneNumber, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Used to establish an Actors.User object
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     */
    public User(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User (String userName, String pswd){
        this.userName = userName;
        this.pswd = pswd;
    }
    public User(){
    }

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }
   /* public String verifyUser(){
        String position = "";
        if (this.getUserName().equals("Customer1") && this.getPswd().equals("password")){
            position = "Customer";
            return position;
        } else if (this.getUserName().equals("Deliverer1") && this.getPswd().equals("password")){
            position = "Deliverer";
            return position;
        }
        else if(this.getUserName().equals("Restaurant Owner") && this.getPswd().equals("password")){
            position = "Restaurant Owner";
            return position;
        }
        return "";
    }*/
    public String verifyUser() throws IOException {
        ArrayList<Customer> customer = this.readFromCustomerFile();
        for (Customer c: customer){
            if (this.getUserName().equals(c.getCustomerID()) && this.getPswd().equals(c.getPassword())){
                return "Customer";
            }
        }
        return "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static class UserBuilder{
        private final String firstName;
        private final String lastName;
        private String address;
        private String phoneNumber;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder address (String address){
            this.address = address;
            return this;
        }

        public UserBuilder phoneNumber (String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public User build(){
            User user = new User(this);
            return user;
        }
    }

    public ArrayList<Customer> readFromCustomerFile() throws IOException {
        File customerFile = new File("src/DataFiles/Customer.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(customerFile));
        ArrayList<String> data = new ArrayList<>();
        ArrayList<Customer> customerList = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            data.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        int index = 0;
        for (int i = 0; i < (data.size()/6); i++) {
                Customer customer = new Customer(data.get(index), data.get(index + 1), data.get(index + 2), data.get(index + 3), data.get(index + 4), data.get(index + 5));
                customerList.add(customer);
                index = index + 6;
        }
        return  customerList;
    }

    public void writeToCustomerFile(String firstName, String lastName, String address, String name) throws IOException{
        Path customerFile = Path.of("src/DataFiles/Customer.txt");
        //FileWriter fileWriter = new FileWriter(customerFile);
        ArrayList<Customer> customers = this.readFromCustomerFile();
        for (int i = 0; i <customers.size(); i++){
            if (customers.get(i).getFirstName().equals(name)){
                customers.get(i).setFirstName(firstName);
                customers.get(i).setLastName(lastName);
                customers.get(i).setAddress(address);
            }
        }
        StringBuilder text = new StringBuilder();
        for (Customer c: customers){
            text.append(c.getFirstName()).append("\n");
            text.append(c.getLastName()).append("\n");
            text.append(c.getAddress()).append("\n");
            text.append(c.getPhoneNumber()).append("\n");
            text.append(c.getCustomerID()).append("\n");
            text.append(c.getPassword()).append("\n");
        }
        Files.writeString(customerFile, text);

    }

    public Restaurant restaurant1 = new Restaurant("Yallah");

    public ArrayList<RestaurantOwner> readFromRestaurantOwnerFile() throws IOException {
        File resOwnerFile = new File("src/DataFiles/RestaurantOwner.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(resOwnerFile));
        ArrayList<String> data = new ArrayList<>();
        ArrayList<RestaurantOwner> resOwnerList = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            data.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        int index = 0;
        for (int i = 0; i < (data.size()/6); i++) {
            RestaurantOwner restaurantOwner = new RestaurantOwner
                    (data.get(index), data.get(index + 1), data.get(index + 2), data.get(index + 3), restaurant1, data.get(index + 5), data.get(index+6), data.get(index+7));
            resOwnerList.add(restaurantOwner);
            index = index + 6;
        }
        return resOwnerList;
    }


    public void writeToResOwnerFile(String firstName, String lastName, String address, String name) throws IOException{
        Path customerFile = Path.of("src/DataFiles/RestaurantOwner.txt");
        //FileWriter fileWriter = new FileWriter(customerFile);
        ArrayList<RestaurantOwner> resOwners = this.readFromRestaurantOwnerFile();
        for (int i = 0; i <resOwners.size(); i++){
            if (resOwners.get(i).getFirstName().equals(name)){
                resOwners.get(i).setFirstName(firstName);
                resOwners.get(i).setLastName(lastName);
                resOwners.get(i).setAddress(address);
            }
        }
        StringBuilder text = new StringBuilder();
        for (RestaurantOwner ro: resOwners){
            text.append(ro.getFirstName()).append("\n");
            text.append(ro.getLastName()).append("\n");
            text.append(ro.getAddress()).append("\n");
            text.append(ro.getPhoneNumber()).append("\n");
            text.append(ro.getRestaurantOwnerID()).append("\n");
            text.append(ro.getPassword()).append("\n");
        }
        Files.writeString(customerFile, text);

    }

    }
