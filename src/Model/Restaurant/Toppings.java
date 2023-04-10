package Model.Restaurant;

import java.util.ArrayList;

public class Toppings implements MenuItem1{
    private String name;
    Double  price;

    public Toppings (String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    @Override
    public String name() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public String prepareDish(){
        return  "";
    }
}
