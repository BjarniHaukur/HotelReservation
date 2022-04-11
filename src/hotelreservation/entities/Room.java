package hotelreservation.entities;

import java.util.ArrayList;

public class Room {

    private Integer id;
    private Integer type;
    private Integer numBeds;
    private ArrayList<Reservation> reservations;

    public Room(Integer id, Integer type, Integer numBeds, ArrayList<Reservation> reservations) {
        this.id = id;
        this.type = type;
        this.numBeds = numBeds;
        this.reservations = reservations;
    }

    public void isAvailable(String dateFrom, String dateTo) {
        for (Reservation reservation : reservations) {
            if (reservation.getDateFrom().equals(dateFrom) || reservation.getDateFrom().equals(dateTo)) {
                System.out.println("Room is not available");
            }
        }
    }

}
