package View.Restaurant;

import Model.Actors.SysAdmin;

public class RestaurantListView {
   /**
    * shows view of restaurants based on role of requesting user
    */
   public void sysAdminView(SysAdmin sysAdmin){
       //sysAdmin sees all restaurants registered in the system
   }

   public void sysAdminViewPending (SysAdmin sysAdmin){
       //sysAdmin sees all restaurants wanting to be added to system
   }
}

