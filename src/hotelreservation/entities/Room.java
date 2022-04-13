package hotelreservation.entities;

import java.util.ArrayList;

public class Room {

    private Integer roomNum;
    private Integer price;
    private Integer numBeds;
    private Integer capacity;
    private Boolean breakfast;

    public Room(Integer roomNum, Integer price, Integer numBeds, Integer capacity, Boolean breakfast) {
        this.roomNum = roomNum;
        this.price = price;
        this.numBeds = numBeds;
        this.capacity = capacity;
        this.breakfast = breakfast;
    }

    // To string
    public String toString() {
        String allInfo = "";
        allInfo += "roomNum: " + this.roomNum + "\n";
        allInfo += "price: " + this.price + "\n";
        allInfo += "numBeds: " + this.numBeds + "\n";
        allInfo += "capacity: " + this.capacity + "\n";
        allInfo += "breakfast: " + this.breakfast + "\n";
        return allInfo;
    }


    /**
     * Checks whether the room is available for the given date range.
     * @params: Long dateFrom, Long dateTo
     * @return: boolean, true if the room is available then, false if not
     */
    // public Boolean isAvailable(Long dateFrom, Long dateTo) {
    //     for (Reservation reservation : reservations) {
            
    //     }
    // }

}
