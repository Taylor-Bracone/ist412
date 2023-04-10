package Model.Actors;

import java.util.ArrayList;
import java.util.List;

public class DelivererList {

    private List<Deliverer> delivererList;
    public DelivererList(){
        this.delivererList = new ArrayList<>();
    }
    public List<Deliverer> getDelivererList(){
        //populate a list of deliverers
        return this.delivererList;
    }
    public void setDelivererList(List<Deliverer> delivererList){
        this.delivererList = delivererList;
    }
}
