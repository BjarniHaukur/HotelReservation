package hotelreservation;
import java.util.ArrayList;
import hotelreservation.entities.*;
import hotelreservation.controllers.HotelControllerMock;
import hotelreservation.data.MockConnection;


public class main {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        HotelControllerMock controller = HotelControllerMock.getInstance();
        System.out.println(controller.getHotelByID(1).getName());
        
    }
}
