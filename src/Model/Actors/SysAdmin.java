package Model.Actors;

import Model.Restaurant.Restaurant;

public class SysAdmin extends User {

    private int adminID;
    /**
     * Used to establish a Actors.Person object
     * Adds, removes, updates restaurant list
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     */
    public SysAdmin(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName, address, phoneNumber);
    }

    public SysAdmin(String firstName, String lastName, String address, String phoneNumber, int adminID) {
        super(firstName, lastName, address, phoneNumber);
        this.adminID = adminID;
    }
}
