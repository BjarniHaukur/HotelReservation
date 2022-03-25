package hotelreservation.data;

import hotelreservation.entities.*;
import java.sql.SQLException;

public interface HotelDataConnection {

    public Hotel getHotelByID(Integer ID) throws SQLException;
    public Room getRoomByID(Integer ID) throws SQLException;


}


