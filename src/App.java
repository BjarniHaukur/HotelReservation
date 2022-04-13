import java.sql.SQLException;
import hotelreservation.controllers.HotelController;
import hotelreservation.data.HotelDataConnection;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        HotelDataConnection connection = HotelDataConnection.getInstance();
        
    }
}
