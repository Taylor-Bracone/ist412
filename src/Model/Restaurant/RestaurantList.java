package Model.Restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RestaurantList implements Subject {
    /**
     * class maintains a list of restaurants
     * sys admin adds restaurant to list
     */
    private ArrayList<Restaurant> restaurantList;
    private ArrayList<Observer> observerList = new ArrayList<>();

    public RestaurantList() {
        //this.restaurantList = restaurantList;
        File fileToRead = new File("restaurants.txt");
        Scanner in = null;
        this.restaurantList = new ArrayList();
        try{
            in = new Scanner(fileToRead);
            while(in.hasNextLine()){
                String nextline = in.nextLine();
                restaurantList.add(new Restaurant(nextline));
            }
        }catch(FileNotFoundException fne){
            String errorString = fne.getMessage();
            System.out.println(errorString);
        }finally{
            if(in != null)
                in.close();
        }
    }
    public void addRestaurantToList(Restaurant rl){
        String fileName = "restaurants.txt";
        PrintWriter out = null;
        try{
            out = new PrintWriter(new FileOutputStream(new File(fileName), true));
            out.println(rl.getRestaurantName());
        }catch(FileNotFoundException fne){
            String errorString = fne.getMessage();
            System.out.println(errorString);
        }finally{
            if(out != null ){
                out.close();
            }
        }
        this.restaurantList.add(rl);
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers() {
        for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
            Observer o = it.next();
            o.update(this);
        }
    }
    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public String toString(){
        //returns string of formatted restaurantList
        return "";
    }
}