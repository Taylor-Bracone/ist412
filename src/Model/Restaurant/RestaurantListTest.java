package Model.Restaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantListTest {
    @Test
    public void testRestaurantList(){
        RestaurantList rl = new RestaurantList();
        for (int i = 0; i < rl.getRestaurantList().size() ; i++) {
            System.out.println(rl.getRestaurantList().get(i).getRestaurantName());
        }
    }

}