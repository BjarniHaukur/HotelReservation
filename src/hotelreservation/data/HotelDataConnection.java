package hotelreservation.data;

import hotelreservation.entities.*;
import java.sql.SQLException;

public interface HrDataConnection {

    public Hotel getHotelByID(String ID) throws SQLException;
    public Room getRoomByID(String ID) throws SQLException;


}


