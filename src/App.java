import java.sql.SQLException;
import hotelreservation.controllers.HotelController;
import hotelreservation.controllers.ReservationController;
import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) throws Exception {
        // Mock reservation

        LocalDate localDate = LocalDate.now();//For reference
        String bla = localDate.toString();
        System.out.println(bla);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(sdf.parse(bla));

        HotelController hotelController = HotelController.getInstance();
        ArrayList<Hotel> hotels = hotelController.getAllHotels();
        // for (Hotel hotel : hotels) {
        //     System.out.println(hotel);
        // }
        String[] gildi = {"gym","wifi","breakfast"};
        ArrayList<Hotel> avhotels = hotelController.filterByInfo(hotels,gildi);
        for (Hotel hotel : avhotels) {
            System.out.println(hotel);
        }
        // ArrayList<Hotel> hotels = hotelController.getAllAvailableHotels(1, 2, localDate, localDate.plusDays(6));
        // for (Hotel hotel : hotels) {
        //     System.out.println(hotel);
        // }
    }

    // public static void main(String[] args) throws Exception{
    //     System.out.println("Hello World!");
    //     // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //     HotelDataConnection connection = HotelDataConnection.getInstance();


    //     ArrayList<Reservation> rooms = connection.getRoomReservations(1, 101);
    //     for (Reservation r : rooms) {
    //         System.out.println(r);
    //     }
    //     // getAllHotels test
    //     // System.out.println(connection.getPrice(2, 101));
    //     // ArrayList<Hotel> allhotels = connection.getAllHotels();
    //     // for(Hotel hotel: allhotels){
    //     //     System.out.println(hotel);
    //     // }
    //     // // getHotelById test
    //     //  Hotel hotel = connection.getHotelById(8);
    //     //  System.out.println(hotel.toString());
         
    //     // // getHotelByName
    //     //  Integer bevid = connection.getHotelIdByName("Beverly Wilshire");
    //     //  System.out.println("Beverly Wilshire id: " + bevid + "\n");
    //     //  Hotel bevHotel = connection.getHotelById(bevid);
    //     //  System.out.println(bevHotel.toString());
        
    //     // ArrayList<Reservation> allresv = connection.getAllReservations();
    //     // ArrayList<Reservation> allresv = connection.getRoomReservations(101,1);
    //     // for(Reservation resv: allresv){
    //     //     // System.out.println(connection.getRoomReservations(resv.getHotelId(), resv.getRoomNum()));
    //     //     // break;
    //     //     System.out.println(resv);
    //     // }

    //     // // getPrice test
    //     //  Integer price = connection.getPrice(1,101);
    //     //  System.out.println("Price of Room 101 at Hotel 1: " + price + "kr");

    //     // // sortAllRoomsByPrice test
    //     // ArrayList<Room> rooms = connection.sortAllRoomsByPrice();
    //     // for(Room room: rooms){
    //     //     System.out.println(room.toString());
    //     // }

    //     // // sortAllRoomsByStars test
    //     // ArrayList<Room> rooms = connection.sortAllRoomsByStars();
    //     // for(Room room: rooms){
    //     //     System.out.println(room.toString());
    //     // }
    //     // // Create Hotel test
    //     // Hotel baron = new Hotel(9,"name",1,"address","image",new Info(5,3,true,true,true,true,true));
    //     // connection.createHotel(baron);
    //     // Hotel hotel = connection.getHotelById(9);
    //     // System.out.println(hotel.toString());
    // }
}
