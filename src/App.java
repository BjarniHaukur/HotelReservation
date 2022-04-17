import java.sql.SQLException;
import hotelreservation.controllers.HotelController;
import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.*;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;

public class App {


    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        HotelDataConnection connection = HotelDataConnection.getInstance();
        // // getAllHotels test
        // ArrayList<Hotel> allhotels = connection.getAllHotels();
        // for(Hotel hotel: allhotels){
        //     System.out.println(hotel.toString());
        // }
        // // getHotelById test
        //  Hotel hotel = connection.getHotelById(8);
        //  System.out.println(hotel.toString());
         
        // // getHotelByName
        //  Integer bevid = connection.getHotelIdByName("Beverly Wilshire");
        //  System.out.println("Beverly Wilshire id: " + bevid + "\n");
        //  Hotel bevHotel = connection.getHotelById(bevid);
        //  System.out.println(bevHotel.toString());
        
        ArrayList<Reservation> allresv = connection.getAllReservations();
        for(Reservation resv: allresv){
            System.out.println(resv.toString());
        }

        // // getPrice test
        //  Integer price = connection.getPrice(1,101);
        //  System.out.println("Price of Room 101 at Hotel 1: " + price + "kr");

        // // sortAllRoomsByPrice test
        // ArrayList<Room> rooms = connection.sortAllRoomsByPrice();
        // for(Room room: rooms){
        //     System.out.println(room.toString());
        // }

        // // sortAllRoomsByStars test
        // ArrayList<Room> rooms = connection.sortAllRoomsByStars();
        // for(Room room: rooms){
        //     System.out.println(room.toString());
        // }
        // // Create Hotel test
        // Hotel baron = new Hotel(9,"name",1,"address","image",new Info(5,3,true,true,true,true,true));
        // connection.createHotel(baron);
        // Hotel hotel = connection.getHotelById(9);
        // System.out.println(hotel.toString());
    }
}
