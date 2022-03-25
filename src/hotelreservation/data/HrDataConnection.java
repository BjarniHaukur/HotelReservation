package hotelreservation.data;

import hotelreservation.entities.*;
import java.sql.SQLException;

public interface HrDataConnection {

    public Hotel getHotelByID(String ID) throws SQLException;
    public Room getRoomByID(String ID) throws SQLException;
    public 


}


// public interface FlightDataConnection {
//     public Flight getFlightById(int id) throws SQLException;
//     public Person getPerson(int id) throws SQLException;
//     public Booking getBooking(int id) throws SQLException;
//     public void createBooking(Booking booking ) throws SQLException;
//     public void updateFood(int id, Boolean newFood) throws SQLException;

// }