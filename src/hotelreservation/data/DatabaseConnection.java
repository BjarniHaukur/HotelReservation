package hotelreservation.data;

import hotelreservation.entities.*;
import java.sql.SQLException;

public interface DatabaseConnection {


    public Hotel getHotelByID(Integer ID) throws SQLException;
    public Room getRoomByID(Integer ID) throws SQLException;


}


