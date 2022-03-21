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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarRating() {
        return this.starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public Price getPriceRating() {
        return this.priceRating;
    }

    public void setPriceRating(Price priceRating) {
        this.priceRating = priceRating;
    }

    public ArrayList<Room> getRooms() {return this.rooms;}

    public void setRooms(ArrayList<Room> rooms) {this.rooms = rooms;}
}
