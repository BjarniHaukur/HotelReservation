package hotelreservation.entities;

import java.util.ArrayList;


public class Hotel {


    enum Price {
        FIRST,
        SECOND,
        THIRD
    }

    String id;
    String name;
    int starRating;
    Price priceRating;
    ArrayList<Room> rooms;
    
    public Hotel(String id, String name, int starRating, Price priceRating, ArrayList<Room> rooms) {}
}
