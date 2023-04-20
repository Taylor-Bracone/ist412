package View.Actors;

import Controller.Actors.DelivererController;
import Model.Actors.Deliverer;

import java.util.Scanner;

public class DeliveryOrderView {
    private DelivererController delivererController = new DelivererController();
    private Deliverer deliverer;

    public DeliveryOrderView(Deliverer deliverer) {
        this.deliverer = deliverer;
        System.out.println("Welcome" + deliverer.getFirstName() + " " + deliverer.getLastName() + " to the Deliverer Interface");
        System.out.println("Select a Functionality:");
        System.out.println("1. View Assigned Order:");
        System.out.println("2. View Past Deliveries:");
        System.out.println("3.Exit Application");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch(option){
            case 1:
                viewCurrentAssignedOrder();
                break;
            case 2:
                viewOrderHistory();
                break;
            case 3:
                exitMessage();
                return;
        }
    }

    public void viewCurrentAssignedOrder(){
        System.out.println("Viewing your current assigned order... ");
        delivererController.displayAssignedOrder(deliverer);
    }

    public void viewOrderHistory(){
        System.out.println("Your order history... ");
        delivererController.displayPastOrders(deliverer);
    }

    public void exitMessage(){
        System.out.println("Thank you!");
    }
}
