package hotelreservation;
import java.util.ArrayList;
import hotelreservation.entities.*;
import hotelreservation.controllers.HotelControllerMock;
import hotelreservation.data.MockConnection;


public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Hotel ranga = new Hotel("Rangá", 1, 5, 1);
        HotelControllerMock controller = new HotelControllerMock();
        controller.addHotel(1, ranga);
        System.out.println(controller.getHotelByID(1).getName());
        
    }
}
