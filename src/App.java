import java.sql.SQLException;
import hotelreservation.controllers.HotelController;
import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.Room;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        HotelDataConnection connection = HotelDataConnection.getInstance();
        // // getAllHotels test
        // ArrayList<Hotel> allhotels = connection.getAllHotels();
        // for(Hotel hotel: allhotels){
        //     System.out.println(hotel.toString());
        // }
        // // getHotelById test
        //  Hotel hotel = connection.getHotelById(2);
        //  System.out.println(hotel.toString());
         
        // // getHotelByName
        //  Integer bevid = connection.getHotelIdByName("Beverly Wilshire");
        //  System.out.println("Beverly Wilshire id: " + bevid + "\n");
        //  Hotel bevHotel = connection.getHotelById(bevid);
        //  System.out.println(bevHotel.toString());
        
        // // getAllReservations test
        // ArrayList<Reservation> allresv = connection.getReservationsByhotelId(1);
        // for(Reservation resv: allresv){
        //     System.out.println(resv.toString());
        // }

        // // getPrice test
        //  Integer price = connection.getPrice(1,101);
        //  System.out.println("Price of Room 101 at Hotel 1: " + price + "kr");

        // sortAllRoomsByPrice test
        ArrayList<Room> rooms = connection.sortAllRoomsByPrice();
        for(Room room: rooms){
            System.out.println(room.toString());
        }

    }
}
