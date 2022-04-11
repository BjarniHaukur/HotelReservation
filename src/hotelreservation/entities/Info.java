package hotelreservation.entities;

import java.util.ArrayList;

public class Info {

    private Boolean gym;
    private Boolean wifi;
    private Boolean breakfast;
    private Boolean pool;
    private Boolean jacuzzi;
    private Boolean bar;
    private Boolean restaurant;
    private ArrayList<String> images;

    public Info(Boolean gym, Boolean wifi, Boolean breakfast, Boolean pool, 
                Boolean jacuzzi, Boolean bar, Boolean restaurant, ArrayList<String> images) {

        this.gym = gym;
        this.wifi = wifi;
        this.breakfast = breakfast;
        this.pool = pool;
        this.jacuzzi = jacuzzi;
        this.bar = bar;
        this.restaurant = restaurant;
        this.images = images;
    }

    public String getInfoString() {
        String allInfo = "";
        allInfo += "Gym: " + this.gym + "\n";
        allInfo += "Wifi: " + this.wifi + "\n";
        allInfo += "Breakfast: " + this.breakfast + "\n";
        allInfo += "Pool: " + this.pool + "\n";
        allInfo += "Jacuzzi: " + this.jacuzzi + "\n";
        allInfo += "Bar: " + this.bar + "\n";
        allInfo += "Restaurant: " + this.restaurant + "\n";
        allInfo += "Images: " + this.images + "\n";
        return allInfo;
    }

}
