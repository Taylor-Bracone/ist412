package Model.Restaurant;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class foodDishTest {
    @Test
     void prepFoodTest(){
        ArrayList<Food> menuItems = new ArrayList<>();
        Sauces sc = new Sauces("Sauce1");
        ArrayList<Sauces> sauces = new ArrayList<>();
        ArrayList<Toppings> toppings = new ArrayList<>();
        sauces.add(sc);

        Toppings tp = new Toppings("Toppings1", 0.99);
        toppings.add(tp);
        Food f1 = new Food("Food", 1.20, "desc", sauces, toppings);
        f1.prepareDish();
        System.out.println(menuItems.get(0));
    }
}