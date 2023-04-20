package Model.Restaurant;

import java.util.ArrayList;

public class Food implements MenuItemInterface {
    private String name;
    private Double price;
    private String description;
    public ArrayList<Sauces> sauces = new ArrayList<>();
    public ArrayList<Toppings> toppings = new ArrayList<>();

    public Food (String name, Double price, String description, ArrayList<Sauces> sauces, ArrayList<Toppings> toppings){
        this.name = name;
        this.price = price;
        this.description = description;
        this.sauces = sauces;
        this.toppings = toppings;
    }

    public Food (String name, Double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public double prepareDish(){
        double price = 0.0;
        for (Sauces s : sauces){
            this.addSauces(s);
            price = price + s.getPrice();
        }
        for (Toppings t : toppings){
            price = price + t.getPrice();
            this.addToppings(t);
        }
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void addToppings(MenuItemInterface topping) {

    }

    public void addSauces(MenuItemInterface sauce) {

    }
}
