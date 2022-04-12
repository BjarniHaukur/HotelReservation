package hotelreservation.entities;

import java.util.ArrayList;
import hotelreservation.controllers.HotelController;

public class Info {

    private Boolean gym;
    private Boolean spa;
    private Boolean wifi;
    private Boolean bar;
    private Boolean restaurant;

    public Info(Boolean gym, Boolean spa, Boolean wifi, Boolean bar, Boolean restaurant) {

        this.gym = gym;
        this.spa = spa;
        this.wifi = wifi;
        this.bar = bar;
        this.restaurant = restaurant;
    }

    public String getInfoString() {
        String allInfo = "";
        allInfo += "Gym: " + this.gym + "\n";
        allInfo += "Spa: " + this.spa + "\n";
        allInfo += "wifi: " + this.wifi + "\n";
        allInfo += "Bar: " + this.bar + "\n";
        allInfo += "Restaurant: " + this.restaurant + "\n";
        return allInfo;
    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
        Info inf = new Info(true, true, true, true, true);
        HotelController hc = HotelController.getInstance();
        System.out.println(hc.bla());
        System.out.println(inf.getInfoString());
        
    }

}
