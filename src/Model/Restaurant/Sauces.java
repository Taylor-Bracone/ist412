package Model.Restaurant;

public class Sauces implements MenuItem1{

    private String name;
    private Double price;

    public Sauces (String name){
        this.name = name;
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
        System.out.println("Sauce prepared");
        return "";
    }
}
