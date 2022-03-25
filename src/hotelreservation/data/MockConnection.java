package hotelreservation.data;

import hotelreservation.entities.*;

public class MockConnection implements HotelDataConnection{
    
    public Hotel getHotelByID(Integer ID) {
        Hotel test = new Hotel("test", 1, 2, 3, null);
        return test;
    } 

    public Room getRoomByID(Integer ID) {
        Room test = new Room(1, 2, 3);
        return test;
    }
}
