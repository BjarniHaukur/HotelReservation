import java.sql.SQLException;
import hotelreservation.controllers.HotelController;
import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.*;
import java.util.ArrayList;
import hotelreservation.entities.*;

public class App {


    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        HotelDataConnection connection = HotelDataConnection.getInstance();
        // getAllHotels test

        // getHotelById test
         Hotel hotel = connection.getHotelById(2);
         System.out.println(hotel.toString());
         
        // getHotelByName
         Integer bevid = connection.getHotelIdByName("Beverly Wilshire");
         System.out.println("Beverly Wilshire id: " + bevid + "\n");
         Hotel bevHotel = connection.getHotelById(bevid);
         System.out.println(bevHotel.toString());

    }
}
