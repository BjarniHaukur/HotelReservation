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
                Boolean jacuzzi, Boolean bar, ArrayList<String> images) {

        this.gym = gym;
        this.wifi = wifi;
        this.breakfast = breakfast;
        this.pool = pool;
        this.jacuzzi = jacuzzi;
        this.bar = bar;
        this.images = images;
    }

}
