package Model.Actors;

public class User {
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

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }
    public String verifyUser(){
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
}
