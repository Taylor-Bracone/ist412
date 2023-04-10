package Model.Restaurant;

import java.util.ArrayList;

public class Menu {
    /**
     * Menu class has list of menu items
     */
    private String name;

    private ArrayList<Food> menuItemsList;

    public Menu(String name, ArrayList<Food> menuItemsList) {
        this.name = name;
        this.menuItemsList = menuItemsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Food> getMenuItemsList() {
        return menuItemsList;
    }
    public void setMenuItemsList(ArrayList<Food> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }
}
