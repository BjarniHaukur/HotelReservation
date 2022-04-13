package hotelreservation.controllers;

import java.sql.SQLException;

import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.Hotel;

public class HotelController {
    
    private static HotelController instance = null;
    private HotelDataConnection connection = HotelDataConnection.getInstance();

    public Hotel getHotelByID(Integer ID) throws SQLException {
        return null;
    }

    public String bla() {
        return "bla";
    }

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
}

