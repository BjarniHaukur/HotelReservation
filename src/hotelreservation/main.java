package hotelreservation;
import java.util.ArrayList;
import hotelreservation.entities.*;


public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Room> rooms = new ArrayList<Room>();
        Hotel ranga = new Hotel("Rangá", 1, 5, 1, rooms);
    }
}
