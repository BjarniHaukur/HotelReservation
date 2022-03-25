package hotelreservation.controllers;

import hotelreservation.data.MockConnection;
import hotelreservation.entities.Hotel;


public class HotelControllerMock {

    MockConnection connection = new MockConnection();
        
    public void addHotel(Integer ID, Hotel hotel) {
        connection.addHotel(ID, hotel);
    }

    public Hotel getHotelByID(Integer ID) {
        return connection.getHotelByID(ID);
    } 

}
