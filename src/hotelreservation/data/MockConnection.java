package hotelreservation.data;

import java.util.HashMap;

import hotelreservation.entities.*;

public class MockConnection implements HotelDataConnection {

    private HashMap<Integer, Hotel> hotels = new HashMap<Integer, Hotel>();
    
    public Hotel getHotelByID(Integer ID) {
        return hotels.get(ID);
    } 

    public void addHotel(Integer ID, Hotel hotel) {
        hotels.put(ID, hotel);
    }

    public Room getRoomByID(Integer ID) {
        return null;
    }

   
}
