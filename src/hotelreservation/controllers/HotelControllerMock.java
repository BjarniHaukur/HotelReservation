package hotelreservation.controllers;

import hotelreservation.data.MockConnection;
import hotelreservation.entities.Hotel;


public class HotelControllerMock {

    private static HotelControllerMock instance = null;
    private MockConnection connection = new MockConnection();
        
    public void addHotel(Integer ID, Hotel hotel) {
        connection.addHotel(ID, hotel);
    }

    public Hotel getHotelByID(Integer ID) {
        return connection.getHotelByID(ID);
    }

    public static HotelControllerMock getInstance() {
        if (instance == null) {
            instance = new HotelControllerMock();
        }
        return instance;
    }

}
