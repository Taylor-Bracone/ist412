package Model.Restaurant;

import Model.Restaurant.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    //add potentially later
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}