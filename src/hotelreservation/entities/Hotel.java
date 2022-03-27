package hotelreservation.entities;

import java.util.ArrayList;

public class Hotel {

    private Integer id;
    private String name;
    private Integer starRating;
    private Integer priceRating;
    private ArrayList<Room> rooms;

    public Hotel(Integer id, String name, Integer starRating, Integer priceRating) {
        this.id = id;
        this.name = name;
        this.starRating = starRating;
        this.priceRating = priceRating;
        this.rooms = null;
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStarRating() {
        return this.starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public Integer getPriceRating() {
        return this.priceRating;
    }

    public void setPriceRating(Integer priceRating) {
        this.priceRating = priceRating;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
