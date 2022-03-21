package hotelreservation.entities;
import hotelreservation.entities.Enums.*;
import java.util.ArrayList;


public class Hotel {


    

    private String id;
    private String name;
    private int starRating;
    private Price priceRating;
    private ArrayList<Room> rooms;
    
    public Hotel(String id, String name, int starRating, Price priceRating, ArrayList<Room> rooms) {
        this.id = id;
        this.name = name;
        this.starRating = starRating;
        this.priceRating = priceRating;
        this.rooms = rooms;
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }
}
