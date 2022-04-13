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

    // To string
    public String toString() {
        String allInfo = "";
        allInfo += this.gym? "gym\n": "";
        allInfo += this.spa? "spa\n": "";
        allInfo += this.wifi? "wifi\n": "";
        allInfo += this.bar? "bar\n": "";
        allInfo += this.restaurant? "restaurant:\n": "";
        if (allInfo.equals("")) {
            allInfo = "No info";
        }
        return allInfo;
    }
}
