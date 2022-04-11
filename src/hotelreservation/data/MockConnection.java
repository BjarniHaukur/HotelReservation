package hotelreservation.data;

import java.util.HashMap;

import hotelreservation.entities.*;

/**
 * Simulates having a connection to our future SQL database
 */

public class MockConnection implements DatabaseConnection {

    private static MockConnection instance = null;
    private HashMap<Integer, Hotel> hotels = new HashMap<Integer, Hotel>();


    /**
     * private constructor that creates three mock hotels
     */
    private MockConnection(){
        hotels.put(1, new Hotel(1, "Rangá", 2, 3));
        hotels.put(2, new Hotel(2, "Hilton", 3, 4));
        hotels.put(3, new Hotel(3, "Ölfus", 4, 5));
    }

    /**
     * Returns the instance of the MockConnection
     * @return the MockConnection instance
     */
    public static MockConnection getInstance(){
        if(instance == null){
            instance = new MockConnection();
        }
        return instance;
    }
    
    /**
     * Returns the Hotel associated with the given ID
     * @param ID: the id
     * @return the MockConnection instance
     */
    public Hotel getHotelByID(Integer ID) {
        return hotels.get(ID);
    } 

    /**
     * Implemented later
     * @return null
     */
    public Room getRoomByID(Integer ID) {
        return null;
    }

   
}

