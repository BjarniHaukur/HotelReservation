package hotelreservation.controllers;

import hotelreservation.data.MockConnection;
import hotelreservation.entities.Hotel;

/**
 * Mock HotelController that simulates how the
 * real controller will work later on.
 */
public class HotelControllerMock {

    private static HotelControllerMock instance = null;
    private MockConnection connection = MockConnection.getInstance();

    public Hotel getHotelByID(Integer ID) {
        return connection.getHotelByID(ID);
    }

    /**
     * Returns the instance of the HotelControllerMock
     * @return the HotelControllerMock instance
     */
    public static HotelControllerMock getInstance() {
        if (instance == null) {
            instance = new HotelControllerMock();
        }
        return instance;
    }

}
