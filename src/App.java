import java.sql.SQLException;
import hotelreservation.controllers.HotelController;
import hotelreservation.data.HotelDataConnection;
import java.util.ArrayList;
import hotelreservation.entities.*;

public class App {


    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        HotelDataConnection connection = HotelDataConnection.getInstance();
        
        ArrayList<Hotel> hotels = connection.getAllHotels();

        for (Hotel hotel : hotels) {
            System.out.println(hotel.getName());
        }

        System.out.println("Bae");
    }
}
