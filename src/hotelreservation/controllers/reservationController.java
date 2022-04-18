package hotelreservation.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.*;

public class ReservationController {
    
    private static ReservationController instance = null;
    private static HotelDataConnection connection = HotelDataConnection.getInstance();


    public static ReservationController getInstance() {
        if (instance == null) {
            instance = new ReservationController();
        }
        return instance;
    }

    public ArrayList<Reservation> getAllReservations() throws Exception {
        return connection.getAllReservations();
    }

    public boolean isAvailable(int hotelId, int roomId, String startDate, String endDate) throws Exception {
        Reservation mockReservation = new Reservation("", "", startDate, endDate, "", "", "", 0, roomId, hotelId);
        ArrayList<Reservation> reservations = connection.getRoomReservations(hotelId, roomId);
        for (Reservation res: reservations) {
            if (res.compareTo(mockReservation) != 0) {
                return false;
            }))
        }
        return connection.isAvailable(hotelId, roomId, startDate, endDate);
    }

    public static void main(String[] args) throws Exception {
        // get and print all reservations
        ArrayList<Reservation> reservations = connection.getAllReservations();
        for (Reservation r : reservations) {
            System.out.println(r);
        }

    }

}


 