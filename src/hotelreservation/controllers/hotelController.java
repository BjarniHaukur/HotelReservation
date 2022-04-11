package hotelreservation.controllers;

import hotelreservation.data.OnlineConnection;
import hotelreservation.entities.Hotel;

public class HotelController {
    
    private static HotelController instance = null;
    private OnlineConnection connection = OnlineConnection.getInstance();

    public Hotel getHotelByID(Integer ID) {
        return connection.getHotelByID(ID);
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
