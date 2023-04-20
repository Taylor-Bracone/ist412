package Model.Restaurant;

public class Toppings implements MenuItemInterface {
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
