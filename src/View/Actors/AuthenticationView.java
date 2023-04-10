package View.Actors;

import Model.Actors.User;

import java.util.Scanner;

public class AuthenticationView {

    public AuthenticationView(){}

    public User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter password: ");
        String pswd = scanner.nextLine();

        User user = new User(userName, pswd);

        return user;

    }
}
