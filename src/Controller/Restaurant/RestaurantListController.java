package Controller.Restaurant;

import Model.Actors.RestaurantOwner;
import Model.Restaurant.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO: add method signatures
public class RestaurantListController {

    private ArrayList<Restaurant> restaurantList;

    /**
     * Establishes the Restaurant.Restaurant List Controller
     * @param restaurantList
     */
    public RestaurantListController(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
    public RestaurantListController(){
        restaurantList = new ArrayList<>();
    }

    public void addRestaurantToList(Restaurant restaurant){
        //adds a restaurant to the list
    }

    public ArrayList<Restaurant> viewRestaurantList() throws IOException {
        createList();
        return restaurantList;
    }

    private ArrayList<Restaurant> createList() throws IOException {
          ArrayList<Food> menuItems1 = readFromMenuForFoodList();
          Menu menu = new Menu(readFromMenuForMenuName(), menuItems1);
          Restaurant r1 = new Restaurant(readFromRestaurantForName(), menu);
          restaurantList.add(r1);

        return restaurantList;
    }

    public ArrayList<Food> readFromMenuForFoodList () throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        BufferedReader reader = null;
        File file = new File("ist412/src/DataFiles/Menu.txt");
        reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) !=null){
            String[] data = line.split(":");
            String key = data[0];
            String value = data[1];
            if (map.containsKey(key)){
                map.get(key).add(value);
            }
            else{
                map.put(key, Stream.of(value).collect(Collectors.toList()));
            }
        }
        ArrayList<String> menuItems = new ArrayList<>();
        Collection<List<String>> items = map.values();
        for (List<String> s : items){
            menuItems.addAll(s);
        }

        ArrayList<String> foodName = new ArrayList<>();
        foodName.addAll(map.get("menuItems"));

        ArrayList<Double> price = new ArrayList<>();
        for (String s: map.get("price")){
            price.add(Double.valueOf(s));
        }

        ArrayList<String> description = new ArrayList<>();
        description.addAll(map.get("description"));

        ArrayList<Food> foodList = new ArrayList<>();
        for (int i = 0; i < foodName.size(); i++){
            Food food = new Food(foodName.get(i), price.get(i), description.get(i));
            foodList.add(food);
        }
        return foodList;
    }

    private String readFromMenuForMenuName () throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        BufferedReader reader = null;
        File file = new File("ist412/src/DataFiles/Menu.txt");
        reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) !=null){
            String[] data = line.split(":");
            String key = data[0];
            String value = data[1];
            if (map.containsKey(key)){
                map.get(key).add(value);
            }
            else{
                map.put(key, Stream.of(value).collect(Collectors.toList()));
            }
        }
        return map.get("restaurantName").toString();
    }

    private String readFromRestaurantForName() throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        BufferedReader reader = null;
        File file = new File("ist412/src/DataFiles/Restaurant.txt");
        reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) !=null){
            String[] data = line.split(":");
            String key = data[0];
            String value = data[1];
            if (map.containsKey(key)){
                map.get(key).add(value);
            }
            else{
                map.put(key, Stream.of(value).collect(Collectors.toList()));
            }
        }

        return map.get("name").toString();
    }
}
