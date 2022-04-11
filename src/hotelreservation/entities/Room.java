package hotelreservation.entities;

import java.util.ArrayList;

public class Room {

    private Integer id;
    private Integer type;
    private Integer numBeds;
    private ArrayList<Reservation> reservations;
    private ArrayList<String> images;

    public Room(Integer id, Integer type, Integer numBeds, ArrayList<Reservation> reservations, ArrayList<String> images) {
        this.id = id;
        this.type = type;
        this.numBeds = numBeds;
        this.reservations = reservations;
        this.images = images;
    }


    /**
     * Checks whether the room is available for the given date range.
     * @params: Long dateFrom, Long dateTo
     * @return: boolean, true if the room is available then, false if not
     */
    public Boolean isAvailable(Long dateFrom, Long dateTo) {
        for (Reservation reservation : reservations) {
            
        }
    }

}
