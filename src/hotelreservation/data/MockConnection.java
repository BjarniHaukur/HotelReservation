package hotelreservation.data;

import hotelreservation.entities.*;

public class MockConnection implements HotelDataConnection{
    
    public Hotel getHotelByID(Integer ID) {
        Hotel test = new Hotel("test", ID, 2, 3);
        return test;
    } 

    public Room getRoomByID(Integer ID) {
        Room test = new Room(ID, 2, 3);
        return test;
    }
}
