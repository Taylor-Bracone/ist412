package Model.Restaurant;

import java.util.ArrayList;

public class Food implements MenuItemInterface {
    private String name;
    private Double price;
    private String description;

    public Food (String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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
