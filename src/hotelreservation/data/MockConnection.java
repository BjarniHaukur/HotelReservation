package hotelreservation.data;

import java.util.HashMap;

import hotelreservation.entities.*;

public class MockConnection implements HotelDataConnection {

    private static MockConnection instance = null;
    private HashMap<Integer, Hotel> hotels = new HashMap<Integer, Hotel>();

    private MockConnection(){
        hotels.put(1, new Hotel(1, "Rangá", 2, 3));
        hotels.put(2, new Hotel(2, "Hilton", 3, 4));
        hotels.put(3, new Hotel(3, "Ölfus", 4, 5));
    }

    public static MockConnection getInstance(){
        if(instance == null){
            instance = new MockConnection();
        }
        return instance;
    }
    
    public Hotel getHotelByID(Integer ID) {
        return hotels.get(ID);
    } 

    public Room getRoomByID(Integer ID) {
        return null;
    }

   
}

