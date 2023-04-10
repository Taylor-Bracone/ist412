package Model.Restaurant;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    /**
     *
     * @param name
     * @param price
     * @param description
     * MenuItem class is used by menu class
     * Restaurant Owner can add or remove menu item
     */
    public MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public String getName(){
        //returns name of menu item
        return name;
    }
    public double getPrice(){
        //returns price of menu item
        return price;
    }
    public String getDescription(){
        //returns description of menu item
        return description;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("\t$"+getPrice()).append("\n\t").append(getDescription());
        return sb.toString();
    }
}
