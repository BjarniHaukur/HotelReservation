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

    public ArrayList<Reservation> getAllReservations(Integer hotelID, Integer roomNumber) throws SQLException {
        return null; //connection.getAllHotels();
    }

    // tests, generateað af CoPilot :O
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        // getAllHotels test

        // getHotelById test
        Hotel hotel = connection.getHotelById(2);
        System.out.println(hotel.toString());
         
        // getHotelByName
        Integer bevid = connection.getHotelIdByName("Beverly Wilshire");
        System.out.println("Beverly Wilshire id: " + bevid + "\n");
        Hotel bevHotel = connection.getHotelById(bevid);
        System.out.println(bevHotel.toString());

    }

}


 