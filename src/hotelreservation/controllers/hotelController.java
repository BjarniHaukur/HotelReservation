package hotelreservation.controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.Hotel;
import hotelreservation.entities.Reservation;
import hotelreservation.entities.Room;

public class HotelController {
    
    private static HotelController instance = null;
    private HotelDataConnection connection = HotelDataConnection.getInstance();

    /**
     * Returns the instance of the HotelController
     * @return the HotelController instance
     */
    public static HotelController getInstance() {
        if (instance == null) {
            instance = new HotelController();
        }
        return instance;
    }

    public ArrayList<Hotel> getAllHotels() throws Exception {
        return connection.getAllHotels();
    }

    public ArrayList<Hotel> getAllAvailableHotels(Integer location, Integer numCustomers, LocalDate from, LocalDate to) throws Exception {
        ReservationController reservController = ReservationController.getInstance();
        String fromString = from.toString();
        String toString = to.toString();
        ArrayList<Hotel> hotels = connection.getHotelsInArea(location);
        for (Hotel hotel : hotels) {
            ArrayList<Room> rooms = connection.getRoomsByHotelId(hotel.getId());
            Integer count = 0;
            for (Room room : rooms) {
                if (!reservController.isAvailable(room.getHotelId(), room.getRoomNum(), fromString, toString)) {
                    rooms.remove(room);
                } else {
                    count += room.getCapacity();
                }
            }
            if (count < numCustomers) {
                hotels.remove(hotel);
            }
        }
        return hotels;
    }

    public Hotel getHotelByID(Integer ID) throws Exception {
        return connection.getHotelById(ID);
    }

    // getHotelIdByName
    public Hotel getHotelIdByName(String name) throws Exception {
        return connection.getHotelByName(name);
    }

    // getHotelsByStarRating
    // public ArrayList<Hotel> getHotelsByStarRating(Integer starRatings) throws Exception {
    //     return connection.getHotelsByStarRating(starRating);
    // }

}

